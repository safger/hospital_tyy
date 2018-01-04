package com.sn.controller.medication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.sn.entity.medication.MedicationReported;
import com.sn.entity.system.Datadictionary;
import com.sn.service.medication.MedicationReportedService;
import com.sn.service.system.DatadictionaryService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller
@RequestMapping("/medication/medicationReported")
public class MedicationReportedController  {
	
	@Autowired
	private MedicationReportedService medicationReportedService;
	@Autowired
	private DatadictionaryService datadictionaryService;
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
	@RequestMapping("showEdit")
	public String showEdit(String fuid,Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid"); 
		com=CompetenceManager.getCom(roleid, "medication/medicationReported/showEdit.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		if(fuid!=null&&fuid.length()>0){
			MedicationReported medicationReported=medicationReportedService.findById(fuid);
			model.put("medicationReported", medicationReported);
		}
		Datadictionary datadictionary=new Datadictionary();
		datadictionary.setCode("002");
		PagedResult<Datadictionary>  p_list=datadictionaryService.findByPageCustom(datadictionary, 1, 999, "sequence");
		model.put("datadictionary_list", p_list.getDataList());
		model.put("active", "medicationReported");
		model.put("com", com);
		return "/medication/medicationReportedEdit"; 
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
		com=CompetenceManager.getCom(roleid, "medication/medicationReported/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		Datadictionary datadictionary=new Datadictionary();
		datadictionary.setCode("002");
		PagedResult<Datadictionary>  p_list=datadictionaryService.findByPageCustom(datadictionary, 1, 999, "sequence");
		model.put("datadictionary_list", p_list.getDataList());
		model.put("active", "medicationReported");
		model.put("com", com);
		return "/medication/medicationReported"; 
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
		String userid=(String)request.getSession().getAttribute("userid");
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
			case "1" : orderByStr = " patient";break;
			case "2" : orderByStr = " patienttype";break;
			case "3" : orderByStr = " ename";break;
			case "4" : orderByStr = " yname";break;
			case "5" : orderByStr = " reporter";break;
			case "6" : orderByStr = " department";break;
			case "7" : orderByStr = " reportdate";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		MedicationReported medicationReported=new MedicationReported();
		
		//medicationReported.setReporterid(userid);
		if(value != null && value[0].length() > 0){ 
			String data[]=value[0].split(";");
			try {
				if(data[0].trim().length()>0){
					medicationReported.setPatient(data[0]);
				}
				if(!data[1].trim().equals("-1")){
					medicationReported.setPatienttype(data[1]);
				}
				if(!data[2].trim().equals("-1")){
					medicationReported.setErrorlevel(data[2]);
				}
				if(data[3].trim().length()>0){
					medicationReported.setReporter(data[3]);
				}
				if(!data[4].trim().equals("-1")){
					medicationReported.setReportertype(data[4]);
				}
				if(!data[5].trim().equals("-1")){
					medicationReported.setDegree(data[5]);
				}
				if(!data[6].trim().equals("-1")){
					medicationReported.setInputerror(data[6]);
				}
				if(data[7].trim().length()>0){
					medicationReported.setYerror(data[7]);
				}
				if(data[8].trim().length()>0){
					medicationReported.setTransfererror(data[8]);
				}
				if(data[9].trim().length()>0){
					medicationReported.setPharmacyerror(data[9]);
				}
				if(data[10].trim().length()>0){
					 medicationReported.setMedicineerror(data[10]);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		Map<String, String> DatadictionaryMap =(Map<String, String>)request.getServletContext().getAttribute("DatadictionaryMap");
		PagedResult<MedicationReported>  page_list = medicationReportedService.findByPageCustom(medicationReported, indexPage, pageSize, orderByStr);
		List<MedicationReported> m_list=page_list.getDataList();
		if(m_list!=null&&m_list.size()>0){
			for(MedicationReported m:m_list){
				m.setPatienttype(DatadictionaryMap.get(m.getPatienttype()));
			}
		}
		model.put("recordsTotal", page_list.getTotal()); 
		model.put("recordsFiltered", page_list.getTotal()); 
		model.put("draw", draw);  
		model.put("data", m_list); 
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
		MedicationReported medicationReported = medicationReportedService.findById(fuid);
		model.put("medicationReported", medicationReported);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param medicationReported 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	public String edit(MedicationReported medicationReported,Map<String,Object>model) throws IOException{
		String userid = (String)request.getSession().getAttribute("userid");
		String id=medicationReported.getFuid();
		if(id!=null&&id.length()>0){
			medicationReportedService.updateSelective(medicationReported);
		}else{
			medicationReported.setReportdate(new Date());
			medicationReported.setReporterid(userid);
			medicationReported.setFuid(UUIDCreater.getUUID()); 
			medicationReported.setCreatedate(new Date());
			medicationReportedService.insertSelective(medicationReported);
		}
		 return "redirect:/medication/medicationReported/show.html"; 
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
			medicationReportedService.deleteById(fuid);
		} 
		return result;
	}
	
}
