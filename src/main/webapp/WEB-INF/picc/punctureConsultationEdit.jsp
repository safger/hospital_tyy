<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
 
.tbt{
	min-width: 80px;
	background-color:#f5f5f5;
}
.su{
font-size:0.9em;
display:inline-block;
transform:scale(0.8);
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
									<h3 class="box-title">穿刺会诊</h3>
								</div> 
								<div class="box-body">
								<form action="" method="post" id="myform">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th colspan="10">病人信息</th>
												<input   type="hidden" value="${tyyPatient.fuid }" name="patientId" /> 
												<input   type="hidden" value="${piccPunctureconsultation.fuid }" name="fuid" />
											</tr>
										</thead> 
										<tbody> 
											<tr> 
												<td class="tbt">住院号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.hospitalnumber }" /></td>
												<td class="tbt">门诊号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.clinicnumber }" name="clinicnumber" /></td>
												<td class="tbt">病人姓名</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.patient }" name="patient" /></td>
												<td class="tbt">性别</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.sex }" name="sex" /></td>
												<td class="tbt">年龄</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.age }" name="age" /></td>
											</tr>
											<tr>
												<td class="tbt">床号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.bedNo }" name="bedNo" /></td>
												<td class="tbt">病区</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.ward }" name="ward" /></td>
												<td class="tbt">科室</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.department }" /></td>
												<td class="tbt">联系电话</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.phone }" name="phone" /></td>
											</tr> 
											<tr>
												<td class="tbt">联系地址</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.address }" name="address" /></td>
												<td class="tbt">病情</td>
												<td colspan="5"><input readonly="readonly" type="text"
													value="${tyyPatient.bcondition }" name="bcondition" /></td>
											</tr>
											<tr>
												<th colspan="10">检验结果</th>
											</tr>
											<tr> 
												<td class="tbt">血常规</td>
												<td colspan="3"> 
												 <input type="radio" checked="checked" value="false" name="bloodRoutine" class="minimal" />&nbsp; 无&nbsp;&nbsp;<input type="radio" value="true" name="bloodRoutine" class="minimal" />&nbsp;有
												 </td>
												<td colspan="6">
													WBC&nbsp;<input type="text" value="${piccPunctureconsultation.wbc }" name="wbc" style="width: 40px" />&nbsp;10<sup class="su">9</sup>/L     &nbsp;&nbsp;PLT&nbsp;<input value="${piccPunctureconsultation.plt }" name="plt" type="text" style="width: 40px" />10<sup class="su">9</sup>/L 
												</td>
											</tr>
											<tr> 
												<td class="tbt">凝血功能</td>
												<td colspan="3"> 
												 <input type="radio" checked="checked" name="bloodClotting" value="false" class="minimal" />&nbsp; 无&nbsp;&nbsp;<input type="radio" value="true" name="bloodClotting" class="minimal" />&nbsp;有
												 </td>
												<td colspan="6">
													&nbsp;&nbsp;&nbsp;PT&nbsp;<input type="number" value="${piccPunctureconsultation.pt }" name='pt' style="width: 40px" />&nbsp;秒     &nbsp;&nbsp;D-二聚体&nbsp;<input value="${piccPunctureconsultation.drjt }" name="drjt" type="text" style="width: 40px" />mg/L
												</td>
											</tr>
											<tr>
												<th colspan="10">会诊要求</th>
											</tr>
											<tr> 
												<td class="tbt">会诊级别</td>
												<td colspan="9"> 
												 <input type="radio" checked="checked" name="consultationLevel" value="1"  class="minimal" />&nbsp; 一般&nbsp;&nbsp;<input type="radio" name="consultationLevel" value="2" class="minimal" />&nbsp;急
												 </td>
											</tr>
											<tr> 
												<td class="tbt">会诊目的</td> 
												<td colspan="9"> 
												 <input type="radio" checked="checked" name="purpose" value="PICC穿刺" class="minimal" />&nbsp; PICC穿刺&nbsp;&nbsp;<input type="radio" name="purpose" value="其他" class="minimal" />&nbsp;其他
												 </td>
											</tr>
											<tr> 
												<td class="tbt">穿刺原因</td>
												<td colspan="3"><select name="punctureCauses">
														<option>化疗</option>
														<option>静脉高营养</option>
														<option>静脉差</option>
														<option>使用特殊药物</option>
												</select> 
												化疗时间<input type="radio" checked="checked" value="1" name="chemotherapyTime" class="minimal" />&nbsp; 今天&nbsp;&nbsp;<input type="radio" value="2" name="chemotherapyTime" class="minimal" />&nbsp;明天
												</td>   
												<td class="tbt">是否床边穿刺</td> 
												<td colspan="5">
													 <input type="radio" checked="checked" name="bedside" value="false" class="minimal" />&nbsp; 否&nbsp;&nbsp;<input value="true" type="radio" name="bedside" class="minimal" />&nbsp;是
												</td>
											</tr>
											<tr> 
												<td class="tbt">初步评估PICC穿刺方式</td>
												<td colspan="9"> 
												 <input type="radio" checked="checked" name="punctureMethod" value="超声" class="minimal" />&nbsp; 超声&nbsp;&nbsp;<input type="radio" name="punctureMethod" value="非超声" class="minimal" />&nbsp;非超声
												 </td>
											</tr>
											<tr>
												<th colspan="10">医护人员信息</th>
											</tr>
											<tr>
												<td class="tbt">申请人姓名</td>
												<td><input type="text" value="${piccPunctureconsultation.sapplicant }" name="sapplicat" /> </td>
												<td class="tbt">申请人代码</td>
												<td><input type="number" value="${piccPunctureconsultation.applicantCode }"
													name="applicantCode" /></td>
												<td class="tbt">申请科室</td>
												<td colspan="3"><input type="text" value="${piccPunctureconsultation.department }" name="department" /></td>
												<td class="tbt">手机短号</td>
												<td colspan="1"><input type="text" value="${piccPunctureconsultation.trumpet }"
													name="trumpet" /></td>
											</tr>
											<tr>
												<td class="tbt">邀请科室</td>
												<td colspan="3"><input type="text"   value="${piccPunctureconsultation.invitation }" name="invitation" />
												</td> 
												<td class="tbt">邀请时间</td>
												<td colspan="5"><input type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="<fmt:formatDate value="${piccPunctureconsultation.invitationTime}" pattern="yyyy-MM-dd HH:mm"/>"
													name="InvitationTime" /></td> 
											</tr>
											<tr>
												<th colspan="10">会诊回执</th>
											</tr>
											<tr>
												<td class="tbt">会诊意见</td>
												<td colspan="9"><textarea style="width: 90%" name="consultationAdvice" rows="3" placeholder="">${piccPunctureconsultation.consultationAdvice }</textarea> </td>
											</tr> 
											<tr> 
												<td class="tbt">会诊人</td>
												<td colspan="3"><input type="text"   value="${piccPunctureconsultation.consultationPeople }" name="consultationPeople" />
												</td> 
												<td class="tbt">联系电话</td>
												<td colspan="5"><input type="text"  value="${piccPunctureconsultation.cphone }"
													name="cphone" /></td> 
											</tr> 
										</tbody>
									</table>
									</form> 
								</div>
								<div class="box-footer" style="text-align: center;">
									<button type="button" onclick="sub()" class="btn btn-primary">完成提交</button>
								</div>
							</div>
						</div>
				</section>
			</div>
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="../system/foot.jsp" />
	</div>
	   
<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript"> 
		$(function() {
			$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
			      checkboxClass: 'icheckbox_minimal-blue',
			      radioClass: 'iradio_minimal-blue'
			    });
			//修改信息
			
			var bloodRoutine='${piccPunctureconsultation.bloodRoutine }';
			$("input[name='bloodRoutine']").each(function (){
				if($(this).val()==bloodRoutine){
					$(this).iCheck('check');
				} 
			})
			var bloodClotting='${piccPunctureconsultation.bloodClotting }';
			$("input[name='bloodClotting']").each(function (){
				if($(this).val()==bloodClotting){
					$(this).iCheck('check');
				} 
			})
			var consultationLevel='${piccPunctureconsultation.consultationLevel }';
			$("input[name='consultationLevel']").each(function (){
				if($(this).val()==consultationLevel){
					$(this).iCheck('check');
				} 
			})
			var purpose='${piccPunctureconsultation.purpose }';
			$("input[name='purpose']").each(function (){
				if($(this).val()==purpose){
					$(this).iCheck('check');
				} 
			})
			var punctureCauses='${piccPunctureconsultation.punctureCauses }';
			$("select[name='punctureCauses']").find("option").each(function (){
				if($(this).val()==punctureCauses){
					$(this).attr("selected","selected");
				}
				
			});
			var chemotherapyTime='${piccPunctureconsultation.chemotherapyTime }';
			$("input[name='chemotherapyTime']").each(function (){
				if($(this).val()==chemotherapyTime){
					$(this).iCheck('check');
				} 
			})
			var bedside='${piccPunctureconsultation.bedside }';
			$("input[name='bedside']").each(function (){
				if($(this).val()==bedside){
					$(this).iCheck('check');
				} 
			})
			var punctureMethod='${piccPunctureconsultation.punctureMethod }';
			$("input[name='punctureMethod']").each(function (){
				if($(this).val()==punctureMethod){
					$(this).iCheck('check');
				} 
			})
			
			
			var sapplicat=$("input[name='sapplicat']").val();
			if(sapplicat==null||sapplicat.length==0){
				$("input[name='sapplicat']").val("${sessionScope.realname}");
			}
			var applicantCode=$("input[name='applicantCode']").val();
			if(applicantCode==null||applicantCode.length==0){
				$("input[name='applicantCode']").val("${sessionScope.username}");
			}
			  
		})
		 
		
		function sub(){
			$("#myform").attr("action","<%=basePath%>backstage/piccPunctureconsultation/edit.html");
			$("#myform").submit();
			 
		}
	</script>
</body>
</html>
