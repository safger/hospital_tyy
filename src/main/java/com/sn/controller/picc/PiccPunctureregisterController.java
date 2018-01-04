package com.sn.controller.picc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sn.common.UUIDCreater;
import com.sn.type.Result;
import com.sn.util.PagedResult;
 





import java.util.*;
import java.io.IOException;  
 






import com.sn.entity.picc.*;
import com.sn.entity.system.Organize;
import com.sn.dao.picc.*;
import com.sn.service.picc.*;  
import com.sn.service.system.OrganizeService;
import com.sn.util.PagedResult;
import com.sn.common.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sn.controller.system.CompetenceManager;

import javax.servlet.http.HttpServletRequest;

import com.sn.controller.system.ComData;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/backstage/piccPunctureregister")
public class PiccPunctureregisterController  {
	
	@Autowired
	private PiccPunctureregisterService piccPunctureregisterService;
	@Autowired
	private VrpuncturePatientService vrpuncturePatientService;
	@Autowired
	private OrganizeService organizeService;
	@Autowired
	private  HttpServletRequest request;
	@Autowired
	private  HttpServletResponse response;
	@Autowired
	private TyyPatientService tyyPatientService;
	
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
	@RequestMapping("showEdit")
	public String showEdit(String punctureId,String patientId,String wardcode, Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "backstage/piccPunctureregister/showEdit.html"); 
		if(!com.getHisSelect()){
			return "error";
		} 
		if (patientId != null && patientId.length() > 0) {
			request.getSession().setAttribute("patientId", patientId);
		} else {
			patientId = (String) request.getSession().getAttribute("patientId");
		}
		TyyPatient tyyPatient=tyyPatientService.findById(patientId);
		request.getSession().setAttribute("OldPatientId", tyyPatient.getPatientId());
		model.put("tyyPatient", tyyPatient); 
		if(punctureId!=null&&punctureId.length()>0){
			PiccPunctureregister piccPunctureregister=piccPunctureregisterService.findById(punctureId);
			model.put("piccPunctureregister", piccPunctureregister);
		}
		PiccPunctureregister punctureregister=new PiccPunctureregister();
		punctureregister.setPatientId(patientId);
		int count=piccPunctureregisterService.countByColum(punctureregister);
		/*Organize organize = new Organize();
		organize.setBqsy("Y");
		List<Organize> org_list = organizeService.selectByColum(organize, "code ")
		model.put("org_list", org_list);;*/
		model.put("count", count);
		model.put("active", "piccPunctureregister");
		model.put("com", com);
		return "/picc/punctureRegisterEdit"; 
	}
	/**
	 * @see 显示列表页
	 * @author xiao
	 * @param model 
	 * @return
	 */
	@RequestMapping("show")
	public String show( Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "backstage/piccPunctureregister/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		
		model.put("active", "piccPunctureregister");
		model.put("com", com);
		return "/picc/punctureregister";
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
			case "1" : orderByStr = " createdate";break;
			case "2" : orderByStr = " hospitalnumber";break;
			case "3" : orderByStr = " clinicnumber";break;
			case "4" : orderByStr = " patient";break;
			case "5" : orderByStr = " ward";break;
			case "6" : orderByStr = " bedNo";break;
			case "7" : orderByStr = " nursingNurse";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		VrpuncturePatient vrpuncturePatient=new VrpuncturePatient();
		// 解析高级搜索
		try {
			if (value != null && value[0].length() > 0) {
				String[] data = value[0].split(",");
				if (data[0] != null&&!data[0].equals("-1") ) {
					vrpuncturePatient.setPunctureCauses(data[0]);
				} 
				if (data[1] != null && data[1].length() > 0) {
					vrpuncturePatient.setWard(data[1]);
				}
				if (data[2] != null && data[2].length() > 0) {
					vrpuncturePatient.setClinicnumber(data[2]);
				}
				if (data[3] != null && data[3].length() > 0) {
					vrpuncturePatient.setPatient(data[3]);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (data[4] != null && data[4].trim().length() > 0) {
					vrpuncturePatient.setCreatedate(dateFormat.parse(data[4].trim()));
				}
				if (data[5] != null && data[5].trim().length() > 0) {
					Date edate = dateFormat.parse(data[5].trim());
					Calendar date = Calendar.getInstance();
					date.setTime(edate);
					date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
					vrpuncturePatient.setTubeTime(date.getTime());
				}
				if (data[6] != null && data[6].trim().length() > 0) {
					vrpuncturePatient.setNursingNurse(data[6].trim());
				}
				if (data[7] != null && data[7].trim().length() > 0) {
					vrpuncturePatient.setHospitalnumber(Integer.parseInt(data[7].trim()));
				}
				if (data[8] != null &&!data[8].equals("-1")) {
					vrpuncturePatient.setPunctureMethod(data[8].trim());
				}
				if (data[9] != null &&!data[9].equals("-1")) {
					vrpuncturePatient.setPunctureSite(data[9].trim());
				}
				if (data[10] != null &&!data[10].equals("-1")) {
					vrpuncturePatient.setPunctureVein(data[10].trim());
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		PagedResult<VrpuncturePatient>  page_list = vrpuncturePatientService.findByPageCustom(vrpuncturePatient, indexPage, pageSize, orderByStr);
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
		PiccPunctureregister piccPunctureregister = piccPunctureregisterService.findById(fuid);
		model.put("piccPunctureregister", piccPunctureregister);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param piccPunctureregister 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	public String edit(PiccPunctureregister piccPunctureregister,Map<String,Object>model) throws IOException{
		String id=piccPunctureregister.getFuid();
		if(id!=null&&id.length()>0){
			piccPunctureregisterService.updateSelective(piccPunctureregister);
		}else{
			piccPunctureregister.setFuid(UUIDCreater.getUUID()); 
			piccPunctureregister.setCreatedate(new Date());
			piccPunctureregisterService.insertSelective(piccPunctureregister);
			TyyPatient tyyPatient=new TyyPatient();
			tyyPatient.setFuid(piccPunctureregister.getPatientId());
			tyyPatient.setModifydate(new Date());
			tyyPatientService.updateSelective(tyyPatient);
		} 
		return "redirect:/backstage/piccPunctureregister/show.html"; 
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
			piccPunctureregisterService.deleteById(fuid);
		} 
		return result;
	}
	
}
