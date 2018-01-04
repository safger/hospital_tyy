<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String indexpage=request.getParameter("page");
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
									<h3 class="box-title">专家信息</h3>
								</div>
								<div class="box-body">
								<form action="<%=basePath %>backstage/doctors/edit.html" method="post" id="myform" enctype="multipart/form-data">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th colspan="10">基本信息</th>
												<input   type="hidden" value="${doctors.fuid }" name="fuid" />
												<input   type="hidden" value="<%=indexpage%>" name="page" />
											</tr>
										</thead>
										<tbody> 
											<tr>
												<td class="active">医生姓名</td>
												<td><input name="name"  type="text" value="${doctors.name }"  /></td>
												<td class="active">医生代码</td>
												<td><input  name="ysdm" type="text" value="${doctors.ysdm }" /></td>
												<td class="active">性别</td>
												<td><input name="sex" type="text" value="${doctors.sex }"   /></td>
												<td class="active">出生年月</td>
												<td colspan="3"><input name="birthday" type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${doctors.birthday}" pattern="yyyy-MM-dd"/>"   /></td>
												 
											</tr> 
											<tr>
												<td class="active">职称</td>
												<td><input   type="text" name="job" value="${doctors.job }"  /></td>
												<td class="active">职务</td>
												<td  ><input  type="text" name="position" value="${doctors.position }"   /></td>
												<td class="active">医生拼音</td>
												<td><input   type="text" name="pinying" value="${doctors.pinying }"  /></td>
												<td class="active">联系电话</td>
												<td colspan="3"><input  type="text" name="phone" value="${doctors.phone }"   /></td>
											</tr>
											<tr>
												<td class="active">是否专家</td>
												<td>	
													<input name="expert" value="0" checked="checked" type="radio" class="minimal" > 否
													<input name="expert" value="1"   type="radio" class="minimal" > 是
												</td>
												<td class="active">专家费</td>
												<td><input type="text" name="expertFee" value="${doctors.expertFee }"  /></td>
												<td class="active">学历</td>
												<td colspan="5"><input  name="education" type="text" value="${doctors.education }"  /></td>
											</tr>
											  
											<tr>
												<th colspan="10">门诊信息</th>
											</tr>
											<tr>
												<td class="active">门诊时间</td>
												<td colspan="3">	
													<input type="text" name="clinicTime" value="${doctors.clinicTime }"  />
												</td>
												<td class="active">门诊地址</td>
												<td colspan="5"><input type="text" name="clinicAddress" value="${doctors.clinicAddress }"  /></td>
											</tr>
											<tr>
												<td class="active">所属科室</td>
												<td colspan="3">	
													<input type="text" name="department" value="${doctors.department }"  />
												</td>
												<td class="active">科室代码</td>
												<td colspan="5"><input type="text" name="dcode" value="${doctors.dcode }"  /></td>
											</tr>
											<tr>
												<th colspan="10">照片信息</th>
											</tr>
											<tr>
												<td class="active">头像图片</td>
												<td colspan="7"> <input type="file" name="avatarFile" /> 
												<img alt="" src="<%=basePath%>backstage/images/${doctors.avatar }/showImg.html" width="120px">
												
												</td>
											</tr> 
											<tr>
												<td class="active">照片信息 </td>
												<td colspan="7"> <input type="file" name="photoFile"/>
													<img alt="" src="<%=basePath%>backstage/images/${doctors.photo }/showImg.html" width="120px">
												</td>
											</tr>
											 <tr>
												<th colspan="10">详细信息</th>
											</tr>
											<tr>
												<td class="active">简介</td>
												<td colspan="9"> 	
													<textarea rows="3" name="introduction" style="width: 90%">${doctors.introduction }</textarea>
												</td>
											</tr>
											<tr>
												<td class="active">研究方向</td>
												<td colspan="9"> 	
													<textarea rows="3" name="research" style="width: 90%">${doctors.research }</textarea>
												</td>
											</tr>
											<tr>
												<td class="active">主攻学科</td>
												<td colspan="9"> 	
													<textarea rows="3" name="attack" style="width: 90%">${doctors.attack }</textarea>
												</td>
											</tr>
											<tr>
												<td class="active">医疗成果</td>
												<td colspan="9"> 	
													<textarea rows="3" name="results" style="width: 90%">${doctors.results }</textarea>
												</td>
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
			 
		 
			
		})
		 
		
		function sub(){
			$("#myform").submit();
		} 
		
		  
	</script>
</body>
</html>
