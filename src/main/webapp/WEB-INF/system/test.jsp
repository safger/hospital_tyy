<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<title>摇号系统</title>
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/font-awesome-4.6.3/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/ionicons-master/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-8">
				<!-- general form elements -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">导入学生Excel</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form role="form">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputFile">文件</label> <input type="file"
									id="exampleInputFile">
							</div>
						</div>
						<div class="box-footer">
							<button type="submit" class="btn btn-primary">导入</button>
						</div>
					</form>
				</div>
				<!-- /.box -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">打乱排序</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<div class="box-footer">
						<button type="button" style="width: 75%;" onclick="du()"
							class="btn btn-block btn-primary btn-lg">打乱</button>
						<button type="button" style="width: 75%; " onclick="yh()"
							class="btn btn-block btn-danger btn-lg">开始摇号</button>
					</div>
					<div class="box-body">
						<div class="row fontawesome-icon-list" id="tt">
							<div class="col-md-3 col-sm-2"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
							<div class="col-md-3 col-sm-4"></div>
						</div>
					</div>
				</div>

			</div>
			<!--/.col (left) -->
			<!-- right column -->
			<div class="col-md-4">
				<!-- Horizontal Form -->
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">摇号结果</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal">
						<div class="box-body" id="bb"></div>
					</form>
				</div>
			</div>
			<!--/.col (right) -->
		</div>
		<!-- /.row -->
	</section>
	<script src="<%=basePath%>js/jquery-1.11.0.min.js"></script>

	<script type="text/javascript">
		var a = 1;
		var arr = [];
		for (var i = 1; i < 51; i++) {
			arr[i] = "学号" + i + " &nbsp;&nbsp;张同学";
		}
		var str = arr.join();
		var te = str.split(",");
		$("#tt").find("div").each(function() {
			$(this).attr("id", "tu" + a);
			$(this).html(te[a]);
			a++;
		})

		function du() {
			arr.sort(function() {
				return 0.5 - Math.random()
			})
			str = arr.join();
			te = str.split(",");
			for (var t = 0; t < te.length; t++) {
				$("#tu" + (t + 1)).html(te[t + 1]);
			}
		}

		function yh() {
			arr.sort(function() {
				return 0.5 - Math.random()
			})
			str = arr.join();
			te = str.split(",");
			for (var t = 0; t < te.length; t++) {
				var ht = "<div id='ba"+t+"' style='display:none'>";
				ht += te[t];
				ht += "</div>";
				$("#bb").append(ht);
			}
			window.setInterval(tet, 1500);
		} 
		var aa = 0;
		function tet() {
			if(aa>=50){
				return;
			}
			
			$("#ba" + aa).fadeIn(3000);
			aa++;
		}
	</script>
</body>
</html>
