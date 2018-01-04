package com.sn.controller.picc;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.sn.entity.picc.PiccMaintenanceregistration;
import com.sn.entity.picc.TyyPatient;
import com.sn.entity.picc.VmpuncturePatient;
import com.sn.service.picc.PiccMaintenanceregistrationService;
import com.sn.service.picc.TyyPatientService;
import com.sn.service.picc.VmpuncturePatientService;
import com.sn.type.Result;
import com.sn.util.PagedResult;

/**
 * @author xiaofeng
 * @version 1.0
 * @since 1.0
 */

@Controller
@RequestMapping("/backstage/piccMaintenanceregistration")
public class PiccMaintenanceregistrationController {

	@Autowired
	private PiccMaintenanceregistrationService piccMaintenanceregistrationService;
	@Autowired
	private VmpuncturePatientService VmpuncturePatientService;
	@Autowired
	private TyyPatientService tyyPatientService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
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
	public String show(Map<String, Object> model) {
		String roleid = (String) request.getSession().getAttribute("roleid");
		com = CompetenceManager.getCom(roleid, "backstage/piccPunctureconsultation/show.html");
		if (!com.getHisSelect()) {
			return "error";
		}
		model.put("active", "piccPunctureconsultation");
		model.put("com", com);
		return "/picc/maintenanceRegistration";
	}

	/**
	 * @see 显示编辑页
	 * @author xiao
	 * @param model
	 * @return
	 */
	@RequestMapping("showEdit")
	public String showEdit(String mpunctureId, String patientId, String wardcode,Map<String, Object> model) {
		String roleid = (String) request.getSession().getAttribute("roleid");
		com = CompetenceManager.getCom(roleid, "backstage/piccPunctureconsultation/showEdit.html");
		if (!com.getHisSelect()) {
			return "error";
		}
		if(patientId!=null&&patientId.length()>0){
			request.getSession().setAttribute("patientId", patientId);
			request.getSession().setAttribute("wardcode", wardcode);
		}else{
			patientId=(String)request.getSession().getAttribute("patientId"); 
		}
		TyyPatient tyyPatient=tyyPatientService.findById(patientId);
		request.getSession().setAttribute("OldPatientId", tyyPatient.getPatientId());
		model.put("tyyPatient", tyyPatient); 
		
		
		
		// 查询维护次数，最近维护情况
		String OldPatientId=(String)request.getSession().getAttribute("OldPatientId");
		TyyPatient tt=new TyyPatient();
		tt.setPatientId(OldPatientId);
		List<TyyPatient> tyyPatient_list=tyyPatientService.selectByColum(tt, null);
		String pid="";
		for(TyyPatient t:tyyPatient_list){
			pid+="'"+t.getFuid()+"',";
		} 
		pid=pid.length()>0?pid.substring(0,pid.length()-1):"";
		if(pid.length()>0){
			PiccMaintenanceregistration patient = new PiccMaintenanceregistration();
			patient.setPatientId(pid);
			PagedResult<PiccMaintenanceregistration> p_list= piccMaintenanceregistrationService.findByPageCustom(patient, 1, 5, " createdate desc");
			List<PiccMaintenanceregistration> m_list= p_list.getDataList();
			if (m_list != null) {
				model.put("count", m_list.size());
				if (m_list.size() > 0) {
					PiccMaintenanceregistration mt = m_list.get(0);
					mt.setFuid(null);
					mt.setMaintenanDate(null);
					model.put("mt", mt);
					model.put("piccMaintenanceregistration", mt);
				} 
			} 
		}
		
		if (mpunctureId != null && mpunctureId.length() > 0) {
			PiccMaintenanceregistration piccMaintenanceregistration = piccMaintenanceregistrationService.findById(mpunctureId);
			model.put("piccMaintenanceregistration", piccMaintenanceregistration);
		}
		model.put("active", "piccMaintenanceregistration");
		model.put("com", com);
		return "/picc/maintenanceRegistrationEdit";
	}

	/**
	 * @see 异步获取列表页
	 * @author xiao
	 * @param indexPage
	 *            当前页
	 * @param pageSize
	 *            每页显示条数
	 * @param model
	 * @return
	 */
	@RequestMapping("getDate")
	@ResponseBody
	public Map<String, Object> getDate(Integer draw, Map<String, Object> model) {
		// 每页返回的条数
		int pageSize = 10;
		String length = request.getParameter("length");
		if (!StringUtils.isEmpty(length)) {
			pageSize = Integer.parseInt(length);
		}
		int start = Integer.parseInt(request.getParameter("start"));
		int indexPage = start / pageSize + 1;
		Map<String, String[]> params = request.getParameterMap();
		String[] sort = params.get("order[0][column]");
		String[] desc = params.get("order[0][dir]");
		String[] value = params.get("search[value]");

		String orderByStr = null;
		switch (sort[0]) {
		case "1":
			orderByStr = " createdate";
			break;
		case "2":
			orderByStr = " hospitalnumber";
			break;
		case "3":
			orderByStr = " clinicnumber";
			break;
		case "4":
			orderByStr = " patient";
			break;
		case "5":
			orderByStr = " ward";
			break;
		case "6":
			orderByStr = " bedNo";
			break;
		case "7":
			orderByStr = " maintainPeople";
			break;
		}
		orderByStr = orderByStr + " " + desc[0];
		VmpuncturePatient vmpuncturePatient = new VmpuncturePatient();
		// 解析高级搜索
		try {
			if (value != null && value[0].length() > 0) {
				String[] data = value[0].split(",");
				if (data[0] != null && !data[0].equals("-1")) {
					vmpuncturePatient.setPartial(data[0]);
				}
				if (data[1] != null && data[1].trim().length() > 0) {
					vmpuncturePatient.setWard(data[1]);
				}
				if (data[2] != null && data[2].trim().length() > 0) {
					vmpuncturePatient.setClinicnumber(data[2]);
				}
				if (data[3] != null && data[3].trim().length() > 0) {
					vmpuncturePatient.setPatient(data[3]);
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (data[4] != null && data[4].trim().length() > 0) {
					vmpuncturePatient.setCreatedate(dateFormat.parse(data[4].trim()));
				}
				if (data[5] != null && data[5].trim().length() > 0) { 
					Date edate = dateFormat.parse(data[5].trim());
					Calendar date = Calendar.getInstance();
					date.setTime(edate);
					date.set(Calendar.DATE, date.get(Calendar.DATE) + 1);
					vmpuncturePatient.setMaintenanDate(date.getTime());
				}
				if (data[6] != null && data[6].trim().length() > 0) {
					vmpuncturePatient.setMaintainPeople(data[6].trim());
				}
				if (data[7] != null && data[7].trim().length() > 0) {
					vmpuncturePatient.setHospitalnumber(Integer.parseInt(data[7].trim()));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PagedResult<VmpuncturePatient> page_list = VmpuncturePatientService.findByPageCustom(vmpuncturePatient, indexPage, pageSize, orderByStr);
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
	public Result getEditData(String fuid, Map<String, Object> model) throws IOException {
		Result result = new Result();
		PiccMaintenanceregistration piccMaintenanceregistration = piccMaintenanceregistrationService.findById(fuid);
		model.put("piccMaintenanceregistration", piccMaintenanceregistration);
		result.setData(model);
		return result;
	}

	/**
	 * @see 执行修改或新增操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param piccMaintenanceregistration
	 *            实体参数
	 * @param model
	 * @return 列表显示页
	 * @throws IOException
	 */
	@RequestMapping("edit")
	public String edit(PiccMaintenanceregistration piccMaintenanceregistration, Map<String, Object> model) throws IOException {
		String id = piccMaintenanceregistration.getFuid();
		if (id != null && id.length() > 0) {
			piccMaintenanceregistrationService.updateSelective(piccMaintenanceregistration);
		} else {
			piccMaintenanceregistration.setFuid(UUIDCreater.getUUID());
			piccMaintenanceregistration.setCreatedate(new Date());
			piccMaintenanceregistrationService.insertSelective(piccMaintenanceregistration);
			String pid=piccMaintenanceregistration.getPatientId();
			TyyPatient tyyPatient=new TyyPatient();
			tyyPatient.setFuid(pid);
			tyyPatient.setModifydate(new Date());
			tyyPatientService.updateSelective(tyyPatient);
			
		}
		return "redirect:/backstage/piccMaintenanceregistration/show.html";
	}

	/**
	 * @see 执行删除操作
	 * @author xiao
	 * @param skey
	 *            搜索关键字
	 * @param id
	 *            主键
	 * @param model
	 * @return 列表显示页
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Result delete(String fuid) {
		Result result = new Result();
		if (fuid != null && fuid.length() > 0) {
			piccMaintenanceregistrationService.deleteById(fuid);
		}
		return result;
	}

	@RequestMapping("getPatient")
	@ResponseBody
	public String getPatient(String mznum, Map<String, Object> model) throws IOException {
		PrintWriter out=response.getWriter();
		TyyPatient tyyPatient=new TyyPatient();
		tyyPatient.setCitizenCard(mznum);
		tyyPatient.setType("2");
		int a=tyyPatientService.countByColum(tyyPatient);
		if(a==0){  
			postSendMessage("http://localhost:8081/backstage/guser/syuser.html?cardid="+mznum,mznum);
		}
		List<TyyPatient>  m_list=tyyPatientService.selectByColum(tyyPatient, null);
		if(m_list!=null&&m_list.size()>0){
			out.print(JSONArray.toJSON(m_list.get(0)));
		}
		return null;
	}
	
	@RequestMapping("historyPatient")
	@ResponseBody
	public String historyPatient(Map<String, Object> model) throws IOException {
		PrintWriter out=response.getWriter();
		TyyPatient tyyPatient=new TyyPatient();
		tyyPatient.setType("2");
		PagedResult<TyyPatient>  p_list=tyyPatientService.findByPageCustom(tyyPatient, 1, 100, " MODIFYDATE desc ");
		out.print(JSONArray.toJSON(p_list.getDataList()));
		return null;
	}
	
	public static String postSendMessage(String httpsUrl, String context) {
		BufferedReader in = null;
		String result = "";
		try {

			URL realUrl = new URL(httpsUrl);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestMethod("POST");
			connection.setRequestProperty("connection", "keep-alive");
			connection.setRequestProperty("Charsert", "UTF-8");
//			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false); 
			// 建立实际的连接 
			connection.connect();
			// System.out.println(context);
			OutputStream os = connection.getOutputStream();
			os.write(context.getBytes("UTF-8"));
			os.flush(); 
			os.close(); 
			// 获取所有响应头字段
			/*
			 * Map<String, List<String>> map = connection.getHeaderFields(); //
			 * 遍历所有的响应头字段 for (String key : map.keySet()) { //
			 * System.out.println(key + "--->" + map.get(key)); }
			 */
			// 定义 BufferedReader输入流来读取URL的响应
			byte[] data = new byte[1024]; 
			int len = 0;
			ByteArrayOutputStream byteoutputStream = new ByteArrayOutputStream();
			if (connection.getInputStream() != null) {
				while ((len = connection.getInputStream().read(data)) != -1) {
					byteoutputStream.write(data, 0, len);
				}
				result = new String(byteoutputStream.toByteArray(), "utf-8");
				// System.out.println(result);

			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
}
