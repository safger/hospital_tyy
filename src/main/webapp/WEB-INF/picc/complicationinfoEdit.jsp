
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>云管理 | 管理</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
	 <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">
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

.ziul li{ 
list-style-type:none;
margin: 7px 0px; 
}
.label.label-primary{ 
	margin: 0px 3px; 
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
				<section class="content-header">
					<h1>
						云管理 <small>管理</small>
					</h1>
				</section>

				<!-- content -->
				<section class="content">
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">列表</h3>

								</div>
								<!-- /.box-header -->
								<div class="box-body"
									style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
									<div class="box box-info">
										<!-- form start -->
										<form class="form-horizontal" name="myform" id="myform" method="post">
											<div class="box-body">
												<div class="form-group">
													<label for="inputEmail3" class="col-sm-2 control-label">输液工具</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="infusionTool" value="${ piccComplicationinfo.infusionTool}" >
													</div>
												</div> 
												<div class="form-group">
													<label for="inputPassword3" class="col-sm-2 control-label">发生部位</label>
													<div class="col-sm-10">
														<textarea rows="3" cols="4" class="form-control" id="parts" name="parts" >${ piccComplicationinfo.parts}</textarea>
													</div>
												</div>
												<div class="form-group">
								 					<label for="inputPassword3" class="col-sm-2 control-label">并发症类型</label>
													<div class="col-sm-10">
														<input  type="hidden" name="ctypeId" value="${tid }" />
														<input  type="hidden" name="fuid" value="${id }" />
														<button style="float: left!important;" type="button" onclick="showBfz()" class="btn btn-info pull-right">选择</button>
														<div id="nr" style="margin: 5px 0px 5px 65px">
															<c:forEach items="${c_list }" var="list">
															<small class="label label-primary">${list.name }</small>
															</c:forEach> 
														</div>
													</div>
												</div>
											</div>
											<!-- /.box-body -->
											<div class="box-footer" style="text-align: center;">
												<button onclick="sub()" type="button" class="btn btn-primary" >保存</button>
											</div>
											<!-- /.box-footer -->
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<div class="box-header with-border" style="border-bottom:0px">
							<button type="button" class="close" style="z-index: 1000" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<i class="fa fa-tv"></i>
							<h3 class="box-title">并发症类型</h3>
						</div>
					</div>
					<div class="modal-body">
						<div class="panel-body" style="padding: 0px;font-size: 12px">
							<ul class="ziul">
							</ul>
							 
						</div>
					</div> 
					<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="bfz()">保存</button>
				</div>
				</div>
			</div>
		</div>
		<jsp:include page="../system/foot.jsp" />
	</div>



	<script src="<%=basePath%>js/layer/layer.js"></script>
<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>


	<script>
		$(function() {
				

		})
		
		function sub(){
			
			$("#myform").attr("action","<%=basePath%>backstage/piccComplicationinfo/edit.html");
			$("#myform").submit();
		}
		
		function showBfz(){
			
			$.ajax({
	    		url:"<%=basePath%>backstage/piccComplicationtype/showData.html",
	    		data:{},
	    		dataType:"json",
	    		 type:"post",
	    		success:function(res){
	    			if(res!=null&&res.length>0){
	    				var ht="";
	    				for(var a=0;a<res.length;a++){
	    					ht+='<li><input class="minimal" cname="'+res[a].name+'" value="'+res[a].fuid+'" type="checkbox" /> '+res[a].name+'</li>';
	    				}
	    				$(".ziul").html(ht);
	    				$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
	    				      checkboxClass: 'icheckbox_minimal-blue',
	    				      radioClass: 'iradio_minimal-blue'
	    				    });
	    			}
	    	        $("#myModal").modal("show"); 
	    		}
	    	});
			
			
		}
		
		function bfz(){
			var data="";
			var ht="";
			 $("input[type='checkbox']:checkbox:checked").each(function(){ 
				data+=$(this).val()+",";
				ht+='<small class="label label-primary">'+$(this).attr("cname")+'</small>';
			}) 
			data=data.length>0?data.substring(0,data.length-1):data;
			$("#nr").html(ht); 
			$("input[name='ctypeId']").val(data); 
			  $("#myModal").modal("hide"); 
		}
	</script>

</body>
</html>

