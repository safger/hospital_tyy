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
									<h3 class="box-title">维护登记</h3>
								</div>
								<div class="box-body">
								<form action="" method="post" id="myform">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th colspan="10">病人信息</th> 
												<input type="hidden" value="${tyyPatient.fuid }" name="patientId" /> 
												<input type="hidden" value="${piccMaintenanceregistration.fuid }" name="fuid" />
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
													value="${tyyPatient.department }"   /></td>
												<td class="tbt">联系电话</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.phone }"  /></td>
											</tr> 
											<tr> 
												<td class="tbt">联系地址</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.address }"   /></td>
												<td class="tbt">病情</td>
												<td colspan="5"><input readonly="readonly" type="text"
			 										value="${tyyPatient.bcondition }" name="bcondition" /></td>
											</tr>
											<tr>
												<th colspan="10">
												<div style="margin-bottom: 0px" class="callout callout-danger">
									               该病人共进行了<strong>${count }</strong>次维护，最近一次维护内容为：${mt.maintainContent }，局部情况：${mt.partial }，其他异常处理：${mt.abnormal }
									              </div>
												</th>
											</tr>
											<tr>
												<th colspan="10">维护信息</th>
											</tr>
											<tr> 
												<td class="tbt">维护类别</td>
												<td colspan="3"> 
												 <select name="maintainType">
												 	<option>置管维护</option>
												 </select>
												 </td> 
												<td colspan="6">
													第${count+1 }次维护 
												</td> 
											</tr>
											<tr> 
												<td class="tbt">维护内容</td>
												<td colspan="9"> 
												  <input name="maintainContent" value="更换肝素帽" type="checkbox" class="minimal" > 更换肝素帽
												  <input name="maintainContent" value="更换贴膜" type="checkbox" class="minimal" > 更换贴膜
												  <input name="maintainContent" value="并发症观察" type="checkbox" class="minimal" > 并发症观察
												  <input name="maintainContent" value="宣教" type="checkbox" class="minimal" > 宣教
												  <input name="maintainContent" value="手册记录" type="checkbox" class="minimal" > 手册记录
												 </td>
											</tr>
											<tr> 
												<td class="tbt">局部情况</td>
												<td colspan="3"> 
												 <select name="partial">
												 	<option>正常</option>
												 	<option>异常</option>
												 </select>
												 </td>
												<td class="tbt" colspan="1">
													异常情况 
												</td> 
												<td colspan="2"> 
												 <select name="abnormal">
														<option>无</option>
														<option>渗液</option>
														<option>出血</option>
														<option>感染</option>
														<option>堵管</option>
														<option>意外拔管</option>
														<option>血栓</option>
														<option>湿疹</option>
												</select> 
												</td> 
												<td class="active">外露(cm)</td>
												<td colspan="2"><input type="number" value="${piccMaintenanceregistration.exposed }" name="exposed" /></td>
											</tr>
											<tr> 
												<td class="tbt">维护备注</td> 
												 <td colspan="9"><textarea style="width: 90%" name="remark" rows="3" placeholder="">${piccMaintenanceregistration.remark	 }</textarea> </td>
											</tr>
											<tr> 
												<td class="tbt">维护地点</td>
												<td colspan="1"><input type="text"   value="${piccMaintenanceregistration.address }" name="address" />
												</td> 　
												<td class="tbt">维护人姓名</td>　
												<td ><input name="maintainPeople" value="${piccMaintenanceregistration.maintainPeople}" type="text"  /> </td>
												<td class="tbt">维护人代码</td>
												<td ><input name="maintainCode" value="${piccMaintenanceregistration.maintainCode}"　 type="text"  /> </td>
												<td class="tbt">维护人日期</td> 
												<td colspan="3" ><input type="text" name="maintenanDate"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="<fmt:formatDate value="${piccMaintenanceregistration.maintenanDate}" pattern="yyyy-MM-dd HH:mm"/>" /> </td>
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
			
			//处理修改
			var maintainContent='${piccMaintenanceregistration.maintainContent}';
			if(maintainContent.length>0){ 
				var ma=maintainContent.split(",");
				$("input[name='maintainContent']").each(function (){
					var mval=$(this).val(); 
					for(var a=0;a<ma.length;a++){
						if(mval==ma[a]){
							$(this).iCheck('check');
							break; 
						}
					}
				})
			}
			
		})
		 
		
		function sub(){
			$("#myform").attr("action","<%=basePath%>backstage/piccMaintenanceregistration/edit.html");
			$("#myform").submit();
			 
		}
	</script>
</body>
</html>
