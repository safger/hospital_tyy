package com.sn.controller.picc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.picc.PiccComplicationinfo;
import com.sn.entity.picc.PiccComplicationmiddle;
import com.sn.entity.picc.PiccComplicationtype;
import com.sn.service.picc.PiccComplicationinfoService;
import com.sn.service.picc.PiccComplicationmiddleService;
import com.sn.service.picc.PiccComplicationtypeService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/backstage/piccComplicationinfo")
public class PiccComplicationinfoController  {
	
	@Autowired
	private PiccComplicationinfoService piccComplicationinfoService;
	@Autowired
	private PiccComplicationmiddleService piccComplicationmiddleService;
	@Autowired
	private PiccComplicationtypeService piccComplicationtypeService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	private ComData com;
	
	
	
	/**
	 * @see 定义接受的时间格式
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值
	}
	
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model 
	 * @return
	 */
	@RequestMapping("show")
	public String show(Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "backstage/piccComplicationinfo/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "piccComplicationinfo");
		model.put("com", com);
		return "/picc/complicationinfo"; 
	}
	 
	/**
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage 当前页
	 * @param pageSize 每页显示条数
	 * @param model 
	 * @return
	 */
	@RequestMapping("getDate")
	@ResponseBody
	public Map<String,Object> getDate(Integer draw,Map<String,Object> model){
		//每页返回的条数
		int pageSize = 10;
		String length = request.getParameter("length");
		if(!StringUtils.isEmpty(length)){
			pageSize = Integer.parseInt(length);
		}
		int start = Integer.parseInt(request.getParameter("start"));
		int indexPage = start / pageSize + 1;
		Map<String, String[]> params = request.getParameterMap();
		String[] sort = params.get("order[0][column]");
		String[] desc = params.get("order[0][dir]");
		String[] value = params.get("search[value]");
		
		String orderByStr = null;
		switch(sort[0]){
			case "0" : orderByStr = " fuid";break;
			case "1" : orderByStr = " createdate";break;
			case "2" : orderByStr = " infusionTool";break;
			case "3" : orderByStr = " parts";break;
			case "4" : orderByStr = " typeId";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		PiccComplicationinfo piccComplicationinfo=new PiccComplicationinfo();
		if(value != null && value[0].length() > 0){
			//icationinfo.setName(value[0]);
		}
		PagedResult<PiccComplicationinfo>  page_list = piccComplicationinfoService.findByPageCustom(piccComplicationinfo, indexPage, pageSize, orderByStr);
		model.put("recordsTotal", page_list.getTotal()); 
		model.put("recordsFiltered", page_list.getTotal()); 
		model.put("draw", draw);  
		model.put("data", page_list.getDataList()); 
		return model;
	}

	/**
	 * @see 获得编辑数据
	 * @author xiao
	 * @throws IOException 
	 */
	@RequestMapping("getEditData") 
	@ResponseBody
	public Result getEditData(String fuid,Map<String,Object> model) throws IOException{
		Result result = new Result();
		PiccComplicationinfo piccComplicationinfo = piccComplicationinfoService.findById(fuid);
		model.put("piccComplicationinfo", piccComplicationinfo);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param piccComplicationinfo 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit") 
	public String edit(PiccComplicationinfo piccComplicationinfo,String ctypeId,Map<String,Object>model) throws IOException{
		String id=piccComplicationinfo.getFuid();
		if(id!=null&&id.length()>0){
			piccComplicationinfoService.updateSelective(piccComplicationinfo);
			//建立关系
			PiccComplicationmiddle piccComplicationmiddle=new PiccComplicationmiddle();
			piccComplicationmiddle.setCinfoId(id);
			piccComplicationmiddleService.deleteByColum(piccComplicationmiddle);
			if(ctypeId!=null&&ctypeId.length()>0){
				String cid[]=ctypeId.split(",");
				for(String _cid:cid){
					piccComplicationmiddle.setFuid(UUIDCreater.getUUID());
					piccComplicationmiddle.setCreatedate(new Date());
					piccComplicationmiddle.setCtypeId(_cid);
					piccComplicationmiddle.setCinfoId(piccComplicationinfo.getFuid());
					piccComplicationmiddleService.insertSelective(piccComplicationmiddle);
				}
			}
		}else{
			piccComplicationinfo.setFuid(UUIDCreater.getUUID()); 
			piccComplicationinfo.setCreatedate(new Date());
			piccComplicationinfoService.insertSelective(piccComplicationinfo);
			//建立关系
			if(ctypeId!=null&&ctypeId.length()>0){
				String cid[]=ctypeId.split(",");
				for(String _cid:cid){
					PiccComplicationmiddle piccComplicationmiddle=new PiccComplicationmiddle();
					piccComplicationmiddle.setFuid(UUIDCreater.getUUID());
					piccComplicationmiddle.setCreatedate(new Date());
					piccComplicationmiddle.setCtypeId(_cid);
					piccComplicationmiddle.setCinfoId(piccComplicationinfo.getFuid());
					piccComplicationmiddleService.insertSelective(piccComplicationmiddle);
				}
			} 
		}
		return "redirect:/backstage/piccComplicationinfo/show.html";
		
	}
	
	/**
	 * @see 显示修改或新增操作
	 */
	@RequestMapping("showEdit")
	public String showEdit(String id,Map<String,Object>model){
		if(id!=null&&id.length()>0){
			PiccComplicationinfo piccComplicationinfo=piccComplicationinfoService.findById(id);
			model.put("piccComplicationinfo", piccComplicationinfo);
			PiccComplicationmiddle piccComplicationmiddle=new PiccComplicationmiddle();
			piccComplicationmiddle.setCinfoId(id);
			List<PiccComplicationtype> c_list=piccComplicationtypeService.selectByVin(piccComplicationmiddle);
			String tid="";
			if(c_list!=null&&c_list.size()>0){
				for(PiccComplicationtype m:c_list){
					tid+=m.getFuid()+",";
				} 
			}
			tid=tid.length()>0?tid.substring(0,tid.length()-1):"";
			model.put("tid", tid);
			model.put("id", id);
			model.put("c_list", c_list);
		}
		
		
		return "/picc/complicationinfoEdit"; 
	}
	
	
	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param id 主键
	 * @param model
	 * @return 列表显示页
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String fuid){
		Result result = new Result();
		if(fuid!=null&&fuid.length()>0){
			PiccComplicationmiddle piccComplicationmiddle=new PiccComplicationmiddle();
			piccComplicationmiddle.setCinfoId(fuid);
			piccComplicationmiddleService.deleteByColum(piccComplicationmiddle);
			piccComplicationinfoService.deleteById(fuid);
		} 
		return result;
	}
	
}
