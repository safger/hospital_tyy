<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String ish=request.getParameter("ish");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>市一医院 | PICC系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
  <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">

<style type="text/css">
.panel {
	display: inline-block;
	width: 30%;
	vertical-align: top;
}

.panel.pa {
	display: inline-block;
	width: 65%;
	margin-left: 2%;
}

.panel-title {
	display: inline-block;
}

.ibox-tools {
	display: inline-block;
	float: right;
	margin-top: 0;
	position: relative;
	padding: 0;
}

.ibox-tools a {
	cursor: pointer;
	margin-left: 5px;
}

.btn-primary {
	background-color: #1ab394;
	border-color: #1ab394;
	color: #FFFFFF;
}

input {
	width: 90%;
}


td {
	border: 1px solid #7A7A7A !important;
}

th {
	border: 1px solid #7A7A7A !important;
}

table {
	font-size: 12px
}
 
 .btn.btn-default.btn-sm.active{
 	color: #436EEE;
 } 
 
</style>

</head>
<body class="skin-blue layout-top-nav">
	<div class="wrapper">
		<c:import url="/system/menuDataTop.html"></c:import>
		<%-- 
		<jsp:include page="head.jsp" />
		<c:import url="/system/menuData.html"></c:import> --%>
		<div class="content-wrapper">
			<div class="container">
				<section class="content">
					<div class="row">
						<div class=col-xs-12>
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">用药错误上报</h3>
								</div>
								<div class="box-body">
								<form action="" method="post" id="myform">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th colspan="10">基本信息</th>
												<input   type="hidden" value="${medicationReported.fuid }" name="fuid" />
											</tr>
										</thead> 
										<tbody> 
											<tr>
												<td class="active">报告人</td>
												<td><input  type="text" name="reporter"
													value="${medicationReported.reporter }"  /></td>
												<td class="active">报告科室</td>
												<td><input name="department" type="text" value="${medicationReported.department }"   /></td>
												<td class="active">联系方式</td>
												<td  colspan="4"><input  type="text" name="phone" value="${medicationReported.phone }"   /></td>
												<%-- <td class="active">报告时间</td>
												<td colspan="3"><input   type="text" name="reportdate" value="${medicationReported.reportdate }"  /></td> --%>
												 
											</tr>
											<tr>
												<td class="active">患者姓名</td>
												<td><input name="patient" type="text" value="${medicationReported.patient }"  /></td>
												<td class="active">门诊号/住院号</td>
												<td><input name="clinicId" type="text" value="${medicationReported.clinicId }"  /></td>
												<td class="active">年龄</td>
												<td><input name="old" type="number" value="${medicationReported.old }"  /></td>
												<td class="active">性别</td>
												<td colspan="3">
													<input name="sex" value="0" checked="checked" type="radio" class="minimal" > 男
													<input name="sex" value="1"   type="radio" class="minimal" > 女
												</td>
											</tr>
											<tr>
												<td class="active">病人类别</td> 
												<td colspan="1">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002001')}">
															   <input name="patienttype" value="${list.code }"   type="radio" class="minimal" >${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
												<td class="active">病区</td>
												<td><input name="ward" type="text" value="${medicationReported.ward }"  /></td>
												<td class="active">临床诊断</td>
												<td colspan="5"><input name="diagnosis" type="text" value="${medicationReported.diagnosis }" name="bcondition" /></td>
											</tr>
											<tr>
												<td class="active">上报人员</td>
												<td colspan="10">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002002')}">
															   <input name="reportertype" value="${list.code }"   type="radio" class="minimal" >${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<th colspan="10">事件情况</th>
											</tr>
											<tr>
												<td class="active">发生时间</td>
												<td><input name="occurtime"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" value="${medicationReported.occurtime }"  /></td>
												<td class="active">发生地址</td>
												<td><input name="occuraddress" type="text" value="${medicationReported.occuraddress }"  /></td>
												<td class="active">引起错误人</td>
												<td><input name="errorper" type="text" value="${medicationReported.errorper }"  /></td>
												<td class="active">与错误相关人</td>
												<td colspan="3"><input name="relatedper" type="text" value="${medicationReported.relatedper }"  /></td>
											</tr>
											<tr>
												<td class="active">导致结果</td>
												<td colspan="10">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002003')}">
															   <input name="dresults" value="${list.code }"   type="radio" class="minimal" >${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">用药结果</td>
												<td colspan="10" style="line-height: 20px">
													第一层级：无错误<br/>
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002004')}">
															   <input name="errorlevel" value="${list.code }"   type="radio" class="minimal" >&nbsp; ${list.fullname } <br/>
															</c:if>
														</c:if>
													</c:forEach>
													第二层级：有错误无伤害<br/>
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002005')}">
															   <input name="errorlevel" value="${list.code }"   type="radio" class="minimal" >&nbsp;${list.fullname } <br/>
															</c:if>
														</c:if>
													</c:forEach>
													第三层级：有错误有伤害<br/>
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002006')}">
															   <input name="errorlevel" value="${list.code }"   type="radio" class="minimal" >&nbsp;${list.fullname } <br/>
															</c:if>
														</c:if>
													</c:forEach>
													第四层级：有错误致死亡<br/>
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002007')}">
															   <input name="errorlevel" value="${list.code }"   type="radio" class="minimal" >&nbsp;${list.fullname } <br/>
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active" rowspan="4">事件伤害程度</td>
												<td colspan="1" >
													<input name="degree" value="002008001"   type="radio" class="minimal" >&nbsp;死亡  &nbsp; 
												</td>
												<td class="active">直接死因</td>
												<td colspan="3"  >
													 <input name="ydeath" type="text" value="${medicationReported.ydeath }"  /><br/>
												</td>
												<td class="active">死亡时间</td>
												<td colspan="3"  >
													 <input name="deathtime"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" value=""  /><br/>
												</td>
											</tr>
											<tr>
												<td colspan="1" >
													<input name="degree" value="002008002"   type="radio" class="minimal" >&nbsp;抢救  &nbsp; 
												</td>
												<td class="active">措施</td>
												<td colspan="7"  >
													 <input name="rescue" type="text" value="${medicationReported.rescue }"  /><br/>
												</td>
											</tr>
											<tr>
												<td colspan="1" >
													<input name="degree" value="002008003"   type="radio" class="minimal" >&nbsp;残疾  &nbsp; 
												</td>
												<td class="active">部位、程度</td>
												<td colspan="7"  >
													 <input name="disability" type="text" value="${medicationReported.disability }"  /><br/>
												</td>
											</tr>
											<tr>
												<td colspan="1" >
													<input name="degree" value="002008004"   type="radio" class="minimal" >&nbsp;暂时伤害  &nbsp; 
												</td>
												<td class="active">部位、程度</td>
												<td colspan="7"  >
													 <input name="hurt" type="text" value="${medicationReported.hurt }"  /><br/>
												</td>
											</tr>
											 <tr>
												<td class="active">恢复过程</td>
												<td colspan="10">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002009')}">
															   <input name="restore" value="${list.code }"   type="radio" class="minimal" >${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<th colspan="10">发生阶段</th>
											</tr>
											<tr>
												<td class="active">医嘱开立错误内容</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002010')}">
															   <input name="yerror" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">医嘱输入错误</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002011')}">
															   <input name="inputerror" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">药房调剂错误</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002012')}">
															   <input name="pharmacyerror" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">传递过程错误</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002013')}">
															   <input name="transfererror" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">给药阶段错误</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002014')}">
															   <input name="medicineerror" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<th colspan="10">医嘱药品</th>
											</tr>
											<tr>
												<td class="active">商品名</td>
												<td><input name="yname" type="text" value="${medicationReported.yname }"  /></td>
												<td class="active">通用名</td>
												<td><input name="ycommonname" type="text" value="${medicationReported.ycommonname }"  /></td>
												<td class="active">剂量</td>
												<td><input name="ydose" type="text" value="${medicationReported.ydose }"  /></td>
												<td class="active">规格</td>
												<td colspan="3">
													<input name="yspecification" type="text" value="${medicationReported.yspecification }"  />
												</td>
											</tr>
											<tr>
												<th colspan="10">错误药品</th>
											</tr>
											<tr>
												<td class="active">商品名</td>
												<td><input name="ename" type="text" value="${medicationReported.ename }"  /></td>
												<td class="active">通用名</td>
												<td><input name="ecommonname" type="text" value="${medicationReported.ecommonname }"  /></td>
												<td class="active">剂量</td>
												<td><input name="edose" type="text" value="${medicationReported.edose }"  /></td>
												<td class="active">规格</td>
												<td colspan="3">
													<input name="especification" type="text" value="${medicationReported.especification }"  />
												</td>
											</tr>
											<tr>
												<th colspan="10">发生可能原因</th>
											</tr>
											<tr>
												<td class="active">与工作及流程相关</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002015')}">
															   <input name="workRelated" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">与个人因素相关</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002016')}">
															   <input name="personalRelated" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">与器材设备因素相关</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002017')}">
															   <input name="deviceRelated" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td class="active">与沟通因素相关</td>
												<td colspan="10" style="line-height: 20px">
													<c:forEach items="${datadictionary_list }" var="list">
														<c:if test="${fn:length(list.code)==9}">
															<c:if test="${fn:startsWith(list.code, '002018')}">
															   <input name="communicationRelated" value="${list.code }"   type="checkbox" class="minimal" > &nbsp;${list.fullname } &nbsp;
															</c:if>
														</c:if>
													</c:forEach>
												</td>
											</tr>
											 <tr>
												<td class="active">简要经过</td>
												<td colspan="9"> 	
													<textarea rows="3" name="jafter" style="width: 90%">${medicationReported.jafter }</textarea>
												</td>
				 							</tr>
										</tbody>
									</table>
									</form>
								</div>
								<div id="cs" class="box-footer" style="text-align: center;">
									<button type="button" onclick="ysub()" class="btn btn-primary">完成提交</button>
								</div>
							</div>
						</div>
				</section>
			</div>
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../system/foot.jsp" />
	</div>
	   <script src="<%=basePath%>js/layer/layer.js"></script>
<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<!-- js分页模板 -->
	<script type="text/javascript">
		$(function() { 
			 $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
  			      checkboxClass: 'icheckbox_minimal-blue',
  			      radioClass: 'iradio_minimal-blue'
  			    });
			 
			 var ish='<%=ish%>';
			 if(ish==1){ 
				 $("#cs").remove();
			 }
			 var patienttype='${medicationReported.patienttype}';
			 $("input[name='patienttype'][value='"+patienttype+"']").iCheck('check');
			 var sex='${medicationReported.sex}'; 
			 $("input[name='sex'][value='"+sex+"']").iCheck('check');
			 var reportertype='${medicationReported.reportertype}';
			 $("input[name='reportertype'][value='"+reportertype+"']").iCheck('check');
		 	 $("input[name='deathtime']").val(timeForm('${medicationReported.deathtime}'));
		 	 $("input[name='occurtime']").val(timeForm('${medicationReported.occurtime}'));
			 var dresults='${medicationReported.dresults}';
			 $("input[name='dresults'][value='"+dresults+"']").iCheck('check');
			 var errorlevel='${medicationReported.errorlevel}';
			 $("input[name='errorlevel'][value='"+errorlevel+"']").iCheck('check');
			 var degree='${medicationReported.degree}';
			 $("input[name='degree'][value='"+degree+"']").iCheck('check');
			 var restore='${medicationReported.restore}';
			 $("input[name='restore'][value='"+restore+"']").iCheck('check');
			 var yerror='${medicationReported.yerror}';
			 if(yerror.length>0){
				 var ye=yerror.split(","); 
				 for(var a=0;a<ye.length;a++){
					 $("input[name='yerror'][value='"+ye[a]+"']").iCheck('check');
				 }
			 }
			
			 var inputerror='${medicationReported.inputerror}';
			 if(inputerror.length>0){
				 var ins=inputerror.split(",");
				 for(var a=0;a<ins.length;a++){
					 $("input[name='pharmacyerror'][value='"+ins[a]+"']").iCheck('check');
				 }
			 }
			   
			  var pharmacyerror='${medicationReported.pharmacyerror}';
			 if(pharmacyerror.length>0){
				 var ph=pharmacyerror.split(",");
				 for(var a=0;a<ph.length;a++){
					 $("input[name='pharmacyerror'][value='"+ph[a]+"']").iCheck('check');
				 }
			 }
			 var transfererror='${medicationReported.transfererror}';
			 if(transfererror.length>0){
				 var tr=transfererror.split(",");
				 for(var a=0;a<tr.length;a++){
					 $("input[name='transfererror'][value='"+tr[a]+"']").iCheck('check');
				 }
			 }
			 var medicineerror='${medicationReported.medicineerror}';
			 if(medicineerror.length>0){
				 var me=medicineerror.split(",");
				 for(var a=0;a<me.length;a++){
					 $("input[name='medicineerror'][value='"+me[a]+"']").iCheck('check');
				 }
			 }
			 var workRelated='${medicationReported.workRelated}';
			 if(workRelated.length>0){
				 var wo=workRelated.split(",");
				 for(var a=0;a<wo.length;a++){
					 $("input[name='workRelated'][value='"+wo[a]+"']").iCheck('check');
				 }
			 }
			 var personalRelated='${medicationReported.personalRelated}';
			 if(personalRelated.length>0){
				 var per=personalRelated.split(",");
				 for(var a=0;a<per.length;a++){
					 $("input[name='personalRelated'][value='"+per[a]+"']").iCheck('check');
				 }
			 }
			 var deviceRelated='${medicationReported.deviceRelated}';
			 if(deviceRelated.length>0){
				 var dev=deviceRelated.split(",");
				 for(var a=0;a<dev.length;a++){
					 $("input[name='deviceRelated'][value='"+dev[a]+"']").iCheck('check');
				 }
			 }
			 var communicationRelated='${medicationReported.communicationRelated}';
			 if(communicationRelated.length>0){
				 var com=communicationRelated.split(",");
				 for(var a=0;a<com.length;a++){
					 $("input[name='communicationRelated'][value='"+com[a]+"']").iCheck('check');
				 }
			 }
			
			 
			
		})
		 
		
		function ysub(){
			 
			$("#myform").attr("action","<%=basePath%>medication/medicationReported/edit.html");
			$("#myform").submit();
			 
		} 
		
		  //时间格式化
	    function timeForm(date){ 
			  if(date!=null&&date.length>0){ 
				  var bdate = new Date(date);  
			    	 var m=bdate.getMinutes().toString(); 
			    	 m=m.length==1?"0"+m.toString() :m; 
			    	 var h=bdate.getHours().toString(); 
			    	 h=h.length==1?"0"+h.toString() :h; 
			    	 var s=bdate.getSeconds().toString();  
			    	 s=s.length==1?"0"+s.toString() :s;      
			    	 var d=bdate.getDate().toString();  
			    	 d=d.length==1?"0"+d.toString() :d;    
			    	 var mm= (bdate.getMonth()  + 1).toString();  
			    	 mm=mm.length==1?"0"+mm.toString() :mm;     
				     bdate = bdate.getFullYear() + "-" + mm + "-" + d+ " " +h + ":" + m + ":" + s;
			    	return bdate;
			  }
	    	
	    }
	</script>
</body>
</html>
