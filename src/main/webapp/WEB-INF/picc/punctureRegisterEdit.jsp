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
<link rel="stylesheet"
	href="<%=basePath%>js/jquery-treegrid-master/css/jquery.treegrid.css">
<link rel="stylesheet"
	href="<%=basePath%>js/jsTree/themes/default/style.min.css" />

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

.active {
	min-width: 80px
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
									<h3 class="box-title">穿刺登记</h3>
								</div>
								<div class="box-body">
								<form action="" method="post" id="myform">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th colspan="10">病人信息</th>
												<input   type="hidden" value="${tyyPatient.fuid }" name="patientId" /> 
												<input   type="hidden" value="${piccPunctureregister.fuid }" name="fuid" />
											</tr>
										</thead> 
										<tbody> 
											<tr>
												<td class="active">住院号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.hospitalnumber }" name="hospitalnumber" /></td>
												<td class="active">门诊号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.clinicnumber }" name="clinicnumber" /></td>
												<td class="active">病人姓名</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.patient }" name="patient" /></td>
												<td class="active">性别</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.sex }" name="sex" /></td>
												<td class="active">年龄</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.age }" name="age" /></td>
											</tr>
											<tr>
												<td class="active">床号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.bedNo }" name="bedNo" /></td>
												<td class="active">病区</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.ward }" name="ward" /></td>
												<td class="active">科室</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.department }" name="department" /></td>
												<td class="active">联系电话</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.phone }" name="phone" /></td>
											</tr>
											<tr>
												<td class="active">联系地址</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.address }" name="address" /></td>
												<td class="active">病情</td>
												<td colspan="5"><input readonly="readonly" type="text"
													value="${tyyPatient.bcondition }" name="bcondition" /></td>
											</tr> 
											<tr>
												<th colspan="10">护理信息</th>
											</tr>
											<tr>
												<td class="active">置管类别</td>
												<td>第
												<c:choose>  
						                            <c:when test="${piccPunctureregister.fuid!=null }">  
						                                         ${count }
						                            </c:when>  
						                            <c:otherwise>  
						                               ${count+1 }
						                            </c:otherwise>  
						                        </c:choose>  
												次置管</td>
												<td class="active">穿刺原因</td>
												<td><select name="punctureCauses">
														<option>化疗</option>
														<option>静脉高营养</option>
														<option>静脉差</option>
														<option>使用特殊药物</option>
												</select></td>
												<td class="active">穿刺方式</td>
												<td colspan="5"><select name="punctureMethod">
												<option>B超引导</option>
												<option>盲穿</option>
												</select></td>
											</tr>
											<tr>
												<td class="active">导管名称</td>
												<td><select name="catheter">
												<option>BARD2</option>
												<option>BARD1</option>
												<option>POWERPICC</option>
												<option>MEDCOMP</option>
												<option>BO</option>
												<option>ARROW管</option>
												</select></td>
												<td class="active">规格</td>
												<td><select name="specification">
												<option>4Fr</option>
												<option>1.9Fr</option>
												<option>3Fr</option>
												<option>5Fr</option>
												<option>14C</option>
												</select></td>
												<td class="active">穿刺部位</td>
												<td><select name="punctureSite">
												<option>右臂肘上</option>
												<option>右臂肘下</option>
												<option>左臂肘上</option>
												<option>左臂肘下</option>
												<option>颈部</option>
												<option>腹股沟</option>
												<option>左大腿</option>
												<option>右大腿</option>
												 
												</select></td>
												<td class="active">穿刺静脉</td>
												<td colspan="3"><select name="punctureVein">
														<option>贵要静脉</option>
														<option>肘正中静脉</option>
														<option>头静脉</option>
														<option>颈外静脉</option>
														<option>颈内静脉</option>
														<option>大隐静脉</option>
														<option>股静脉</option>
														<option>肱静脉</option>
														<option>腘静脉</option>
												</select></td>
											</tr>
											<tr>
												<td class="active">测量方法</td>
												<td><select name="measuring">
														<option>体外测量</option>
														<option>胸片测量</option>
												</select></td>
												<td class="active">预计测量长度(cm)</td>
												<td><input type="number" value="${piccPunctureregister.expectedMeasure }"
													name="expectedMeasure" /></td>
												<td class="active">臂围(cm)</td>
												<td><input type="number" value="${piccPunctureregister.buttocks }" name="buttocks" /></td>
												<td class="active">初次置管长度(cm)</td>
												<td><input type="number" value="${piccPunctureregister.tubeLen }" name="tubeLen" /></td>
												<td class="active">外露(cm)</td>
												<td><input type="number" value="${piccPunctureregister.exposed }" name="exposed" /></td>
											</tr>
											<tr>
												<td class="active">初次导管末端位置</td>
												<td><select name="cendPosition">
														<option>上腔静脉</option>
														<option>下腔静脉</option>
														<option>颈内静脉</option>
														<option>锁骨下静脉</option>
														<option>心房内</option>
														<option>头臂静脉</option>
														<option>未定位</option>
														<option>腔静脉</option>
														<option>腘静脉</option>
												</select></td>
												<td class="active">调整后末端位置</td>
												<td><input type="text" value="${piccPunctureregister.tendPosition }" name="tendPosition" /></td>
												<td class="active">左臂围(cm)</td>
												<td><input type="number" value="${piccPunctureregister.leftButtocks }" name="leftButtocks" /></td>
												<td class="active">右臂围</td>
									 			<td><input type="number" value="${piccPunctureregister.rightButtocks }" name="rightButtocks" /></td>
												<td class="active">调整后置管长度(cm)</td>
												<td><input type="number" value="${piccPunctureregister.ttubeLen }" name="ttubeLen" /></td>
											</tr>
											<tr>
												<td class="active">穿刺次数</td>
												<td><input type="number" value="${piccPunctureregister.punchesNum }" name="punchesNum" />
												</td>
												<td class="active">送管次数</td>
												<td><input type="number" value="${piccPunctureregister.pipeNum }" name="pipeNum" /></td>
												<td colspan="6"></td>
											</tr>
											<tr>
												<td class="active">异常情况处理</td>
												<td><select name="qexception">
														<option>无</option>
														<option>异位</option>
														<option>过深</option>
														<option>过浅</option>
														<option>其他</option>
												</select></td>
												<td colspan="8"></td>
											</tr>
											<tr>
												<th colspan="10">医务人员信息</th>
											</tr>
											<tr>
												<td class="active">宣教护士</td>
												<td><input type="text" value="${piccPunctureregister.missionaryNurse }" name="missionaryNurse" /></td>
												<td class="active">置管护士代码</td>
												<td><input type="number" value="${piccPunctureregister.nursingNurseNum }"
													name="nursingNurseNum" /></td>
												<td class="active">置管护士名称</td>
												<td><input type="text" value="${piccPunctureregister.nursingNurse }" name="nursingNurse" /></td>
												<td class="active">置管科室</td>
												<td colspan="3"> 
												<input type="text" value="${piccPunctureregister.controlDepartment }"
													name="controlDepartment" /></td>
											</tr>
											<tr>
												<td class="active">置管日期</td>
												<td colspan="3"><input type="text"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})"   value="<fmt:formatDate value="${piccPunctureregister.tubeTime}" pattern="yyyy-MM-dd HH:mm"/>" name="tubeTime" />
												</td> 
												<td class="active">拔管日期</td>
												<td colspan="3"><input type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="<fmt:formatDate value="${piccPunctureregister.extubationTime}" pattern="yyyy-MM-dd HH:mm"/>"
													name="extubationTime" /></td> 
												<td class="active">置留天数</td> 
												<td><input type="number" value="${piccPunctureregister.indwelling }" name="indwelling" /></td>
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
	   
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<!-- js分页模板 -->
	<script type="text/javascript">
		$(function() { 
			var punctureCauses='${piccPunctureregister.punctureCauses }'; 
			if(punctureCauses.length>0){
				$("select[name='punctureCauses']").val(punctureCauses);
			}
			var punctureMethod='${piccPunctureregister.punctureMethod }';
			if(punctureMethod.length>0){ 
				$("select[name='punctureMethod']").val(punctureMethod);
			} 
			var catheter='${piccPunctureregister.catheter }';
			if(catheter.length>0){
				$("select[name='catheter']").val(catheter);
			} 
			var specification='${piccPunctureregister.specification }';
			if(specification.length>0){
				$("select[name='specification']").val(specification);
			} 
			var punctureSite='${piccPunctureregister.punctureSite }';
			if(punctureSite.length>0){
				$("select[name='punctureSite']").val(punctureSite);
			}  
			var punctureVein='${piccPunctureregister.punctureVein }';
			if(punctureVein.length>0){
				$("select[name='punctureVein']").val(punctureVein);
			} 
			var measuring='${piccPunctureregister.measuring }';
			if(measuring.length>0){
				$("select[name='measuring']").val(measuring);
			} 
			var cendPosition='${piccPunctureregister.cendPosition }';
			if(cendPosition.length>0){
				$("select[name='cendPosition']").val(cendPosition); 
			} 
			var qexception='${piccPunctureregister.qexception }';
			if(qexception.length>0){
				$("select[name='qexception']").val(qexception);
			} 
			
			var missionaryNurse=$("input[name='missionaryNurse']").val();
			if(missionaryNurse==null||missionaryNurse.length==0){
				$("input[name='missionaryNurse']").val("${sessionScope.realname}");
				$("input[name='nursingNurse']").val("${sessionScope.realname}");
			}
			var nursingNurseNum=$("input[name='nursingNurseNum']").val();
			if(nursingNurseNum==null||nursingNurseNum.length==0){
				$("input[name='nursingNurseNum']").val("${sessionScope.username}");
			}
			
		}) 
		 
		
		function sub(){
			$("#myform").attr("action","<%=basePath%>backstage/piccPunctureregister/edit.html");
			$("#myform").submit();
			 
		}
	</script>
</body>
</html>
