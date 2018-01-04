package com.sn.controller.picc;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.alibaba.fastjson.JSONArray;
import com.sn.common.UUIDCreater;
import com.sn.controller.system.ComData;
import com.sn.controller.system.CompetenceManager;
import com.sn.entity.picc.PiccComplication;
import com.sn.entity.picc.PiccComplicationinfo;
import com.sn.entity.picc.PiccComplicationtype;
import com.sn.entity.picc.TyyPatient;
import com.sn.entity.picc.VcomplicationPatient;
import com.sn.service.picc.PiccComplicationService;
import com.sn.service.picc.PiccComplicationinfoService;
import com.sn.service.picc.PiccComplicationtypeService;
import com.sn.service.picc.TyyPatientService;
import com.sn.service.picc.VcomplicationPatientService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/backstage/piccComplication")
public class PiccComplicationController  {
	
	@Autowired
	private PiccComplicationService piccComplicationService;
	@Autowired
	private PiccComplicationinfoService piccComplicationinfoService;
	@Autowired
	private VcomplicationPatientService vcomplicationPatientService;
	@Autowired
	private TyyPatientService tyyPatientService;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
		com=CompetenceManager.getCom(roleid, "backstage/piccComplication/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "piccComplication");
		model.put("com", com);
		return "/picc/complication"; 
	}
	 

	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model 
	 * @return
	 */
	@RequestMapping("showEdit")
	public String showEdit(String patientId,String comId,Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "backstage/piccComplication/showEdit.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		//查询病人信息
		if(patientId!=null&&patientId.length()>0){
			request.getSession().setAttribute("patientId", patientId);
		}else{
			patientId=(String)request.getSession().getAttribute("patientId"); 
		}
		TyyPatient tyyPatient=tyyPatientService.findById(patientId);
		model.put("tyyPatient", tyyPatient);
		//查询输液工具
		List<PiccComplicationinfo> info_list=piccComplicationinfoService.selectAll(null);
		model.put("info_list", info_list);
		 
		if(comId!=null&&comId.length()>0){
			PiccComplication piccComplication=piccComplicationService.findById(comId);
			model.put("piccComplication", piccComplication);
		} 
		model.put("active", "piccComplication");
		model.put("com", com);
		return "/picc/complicationEdit"; 
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
			case "1" : orderByStr = " hospitalnumber";break;
			case "2" : orderByStr = " clinicnumber";break;
			case "3" : orderByStr = " patient";break;
			case "4" : orderByStr = " ward";break;
			case "5" : orderByStr = " bedNo";break;
			case "6" : orderByStr = " btype";break;
			case "7" : orderByStr = " createdate";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		VcomplicationPatient piccComplication=new VcomplicationPatient();
		if(value != null && value[0].length() > 0){
			//piccComplication.setName(value[0]);
		}
		PagedResult<VcomplicationPatient>  page_list = vcomplicationPatientService.findByPageCustom(piccComplication, indexPage, pageSize, orderByStr);
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
		VcomplicationPatient vcomplicationPatient=new VcomplicationPatient();
		vcomplicationPatient.setFuid(fuid);
		List<VcomplicationPatient>  v_list= vcomplicationPatientService.selectByColum(vcomplicationPatient, null);
		if(v_list!=null&&v_list.size()>0){
			model.put("piccComplication", v_list.get(0));
		}
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param piccComplication 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	public String edit(PiccComplication piccComplication,Map<String,Object>model) throws IOException{
		String id=piccComplication.getFuid();
		if(id!=null&&id.length()>0){
			piccComplicationService.updateSelective(piccComplication);
		}else{
			piccComplication.setFuid(UUIDCreater.getUUID()); 
			piccComplication.setCreatedate(new Date());
			piccComplicationService.insertSelective(piccComplication);
		}
		return "redirect:/backstage/piccComplication/show.html";
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
			piccComplicationService.deleteById(fuid);
		} 
		return result;
	}
	
	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param id 主键
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("complication")
	@ResponseBody
	public Result complication(String fuid) throws IOException{
		PrintWriter out=response.getWriter();
		PiccComplicationtype piccComplicationtype=new PiccComplicationtype();
		piccComplicationtype.setCinfoId(fuid);
		List<PiccComplicationtype> p_list=piccComplicationtypeService.selectByView(piccComplicationtype);
		out.print(JSONArray.toJSON(p_list));
		return null;
	}
	
	
}
