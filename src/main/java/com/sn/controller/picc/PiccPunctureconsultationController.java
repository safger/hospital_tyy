package com.sn.controller.picc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.sn.entity.picc.PiccPunctureconsultation;
import com.sn.entity.picc.TyyPatient;
import com.sn.entity.picc.VcpuncturePatient;
import com.sn.service.picc.PiccPunctureconsultationService;
import com.sn.service.picc.TyyPatientService;
import com.sn.service.picc.VcpuncturePatientService;
import com.sn.type.Result;
import com.sn.util.PagedResult;


/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */



@Controller 
@RequestMapping("/backstage/piccPunctureconsultation")
public class PiccPunctureconsultationController  {
	
	@Autowired
	private PiccPunctureconsultationService piccPunctureconsultationService;
	@Autowired
	private VcpuncturePatientService vcpuncturePatientService;
	@Autowired
	private TyyPatientService tyyPatientService;
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
		com=CompetenceManager.getCom(roleid, "backstage/piccPunctureconsultation/show.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		model.put("active", "piccPunctureconsultation");
		model.put("com", com);
		return "/picc/punctureConsultation"; 
	}
	/**
	 * @see 显示编辑页 
	 * @author xiao
	 * @param model 
	 * @return
	 */ 
	@RequestMapping("showEdit")
	public String showEdit(String cpunctureId,String patientId,Map<String,Object>model){ 
		String roleid=(String)request.getSession().getAttribute("roleid");
		com=CompetenceManager.getCom(roleid, "backstage/piccPunctureconsultation/showEdit.html"); 
		if(!com.getHisSelect()){
			return "error";
		}
		if(patientId!=null&&patientId.length()>0){
			request.getSession().setAttribute("patientId", patientId);
		}else{
			patientId=(String)request.getSession().getAttribute("patientId"); 
		}
		TyyPatient tyyPatient=tyyPatientService.findById(patientId);
		model.put("tyyPatient", tyyPatient);  
		if(cpunctureId!=null&&cpunctureId.length()>0){
			PiccPunctureconsultation piccPunctureconsultation=piccPunctureconsultationService.findById(cpunctureId);
			model.put("piccPunctureconsultation", piccPunctureconsultation);
		} 
		model.put("active", "piccPunctureconsultation");
		model.put("com", com);
		return "/picc/punctureConsultationEdit"; 
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
			case "6" : orderByStr = " consultationPeople";break;
			case "7" : orderByStr = " bedNo";break;
			case "8" : orderByStr = " purpose";break;
			case "9" : orderByStr = " consultationLevel";break;
			case "10" : orderByStr = " sapplicant";break;
			case "11" : orderByStr = " consultationPeople";break;
		}
		orderByStr = orderByStr + " " + desc[0];
		VcpuncturePatient vcpuncturePatient=new VcpuncturePatient();
		// 解析高级搜索
				try {
					if (value != null && value[0].length() > 0) {
						String[] data = value[0].split(",");
						if (data[0] != null&&!data[0].equals("-1") ) {
							vcpuncturePatient.setConsultationLevel(Integer.parseInt(data[0]));
						}
						if (data[1] != null && data[1].length() > 0) {
							vcpuncturePatient.setWard(data[1]);
						}
						if (data[2] != null && data[2].length() > 0) {
							vcpuncturePatient.setClinicnumber(data[2]);
						}
						if (data[3] != null && data[3].length() > 0) {
							vcpuncturePatient.setPatient(data[3]);
						}
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						if (data[4] != null && data[4].trim().length() > 0) {
							vcpuncturePatient.setCreatedate(dateFormat.parse(data[4].trim()));
						}
						if (data[5] != null && data[5].trim().length() > 0) {
							Date edate = dateFormat.parse(data[5].trim());
							Calendar date = Calendar.getInstance();
							date.setTime(edate);
							date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
							vcpuncturePatient.setInvitationTime(date.getTime());
						}
						if (data[6] != null && data[6].trim().length() > 0) {
							vcpuncturePatient.setConsultationPeople(data[6].trim());
						}
						if (data[7] != null && data[7].trim().length() > 0) {
							vcpuncturePatient.setHospitalnumber(Integer.parseInt(data[7].trim()));
						}
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
		PagedResult<VcpuncturePatient>  page_list = vcpuncturePatientService.findByPageCustom(vcpuncturePatient, indexPage, pageSize, orderByStr);
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
		PiccPunctureconsultation piccPunctureconsultation = piccPunctureconsultationService.findById(fuid);
		model.put("piccPunctureconsultation", piccPunctureconsultation);
		result.setData(model);
		return result;
	}
	
	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey 搜索关键字
	 * @param piccPunctureconsultation 实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException 
	 */
	@RequestMapping("edit")
	public String edit(PiccPunctureconsultation piccPunctureconsultation,Map<String,Object>model) throws IOException{
		String id=piccPunctureconsultation.getFuid();
		if(id!=null&&id.length()>0){ 
			piccPunctureconsultationService.updateSelective(piccPunctureconsultation);
		}else{
			piccPunctureconsultation.setFuid(UUIDCreater.getUUID()); 
			piccPunctureconsultation.setCreatedate(new Date());
			piccPunctureconsultationService.insertSelective(piccPunctureconsultation);
			TyyPatient tyyPatient=new TyyPatient();
			tyyPatient.setFuid(piccPunctureconsultation.getPatientId());
			tyyPatient.setModifydate(new Date());
			tyyPatientService.updateSelective(tyyPatient);
		}
		return "redirect:/backstage/piccPunctureconsultation/show.html"; 
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
			piccPunctureconsultationService.deleteById(fuid);
		} 
		return result;
	}
	
}
