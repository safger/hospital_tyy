
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
<style>
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

input.form-control {
	height: 28px;
	width: 100px;
	display: inline;
}

.head-find {
	padding: 0 20px;
}

.head-find .row {
	margin-bottom: 15px;
}

.head-find .form-new-input {
	position: relative;
	font-family: "Microsoft YaHei";
}

.head-find .form-new-input span { /*position: absolute;*/
	width: 77px;
	height: 32px;
	background: #ecf0f5;
	font-size: 14px;
	color: #000;
	line-height: 32px; /* left: 1px; top: 1px; */
	padding-left: 5px;
	float: left;
	border: 1px solid #d2d6de;
	border-right: none;
}

.head-find .form-new-input .fis {
	float: left;
	width: 110px;
	border: 1px solid #d2d6de;
	font-size: 14px;
	color: #000;
	height: 32px;
	line-height: 30px;
	padding-left: 5px;
	padding-right: 5px;
	padding-top: 0;
	padding-bottom: 0;
}

.head-find .form-new-input.form-new-input-date .fis {
	width: 110px;
}

.head-find .form-new-input.form-new-input-date b {
	display: block;
	float: left;
	padding: 0 5px;
	height: 32px;
	line-height: 32px;
}

.head-find .form-new-input-date .fis.fis2 {
	padding-left: 5px;
	width: 110px;
}
</style>
</head>
<!-- <body class="hold-transition skin-blue sidebar-mini">  -->
<body class="skin-blue layout-top-nav">
	<div class="wrapper">
		<c:import url="/system/menuDataTop.html"></c:import>
		<%-- <jsp:include page="../system/head.jsp" />
		<c:import url="/system/menuData.html"></c:import>  --%>
		<div class="content-wrapper">
			<div class="container">
				<!-- content -->
				<section class="content">
					<div class="error-page">
						<h2 class="headline text-yellow">404</h2>

						<div class="error-content">
							<h3>
								<i class="fa fa-warning text-yellow"></i> 您的账号无权限使用该功能
							</h3>

							<p>权限不足， 请联系系统管理员设置权限</p>

							<form class="search-form">
								<div class="input-group">
									<input type="text" name="search" class="form-control"
										placeholder="Search">

									<div class="input-group-btn">
										<button type="submit" name="submit"
											class="btn btn-warning btn-flat">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
								<!-- /.input-group -->
							</form>
						</div>
						<!-- /.error-content -->
					</div>
					<!-- /.error-page -->
				</section>
			</div>
		</div>
		<jsp:include page="../system/foot.jsp" />
	</div>


	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>

</body>
</html>

