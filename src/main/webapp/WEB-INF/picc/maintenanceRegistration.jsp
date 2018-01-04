
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
					<div class="box box-default collapsed-box">
						<div class="box-header with-border">
							<h3 class="box-title">高级搜索</h3>
							<div class="box-tools pull-right">
								<button type="button" class="btn btn-box-tool"
									data-widget="collapse">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<div class="box-body">
							<div class="head-find">
								<div class="row">
									<div class="col-xs-3">
										<div class="form-new-input">
											<span>门诊号：</span> <input type="text" id="clinicnumber" class="fis">
										</div>
									</div>
									<div class="col-xs-3">
										<div class="form-new-input">
											<span>住院号：</span> <input type="number" id="hospitalnumber" class="fis">
										</div>
									</div>
									<div class="col-xs-3">
										<div class="form-new-input">
											<span>病区：</span> <input type="text" id="ward" class="fis">
										</div>
									</div>
									<div class="col-xs-3">
										<div class="form-new-input">
											<span>病人：</span> <input type="text" id="patient" class="fis">
										</div>
									</div>
									
								</div>
								<div class="row">
									<div class="col-xs-3">
										<div class="form-new-input">
											<span>维护护士：</span> <input type="text" id="maintainPeople" class="fis">
										</div>
									</div> 
									<div class="col-xs-3">  
										<div class="form-new-input">
											<span>局部情况：</span> <select  id="partial"
												class="fis">
												<option value="-1">所有</option>
												<option>正常</option>
												<option>不正常</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6">
										<div class="form-new-input form-new-input-date">
											<span>日期：</span> <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="sstime" class="fis">
											<b>:</b> <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" id="setime" class="fis fis2">
										</div>
									</div>
								</div>
								 <div class="row" 　 > 
					              <div style="width: 90%;text-align: center;">
					                 	<button type="button" style="width: 100px;display: inline;" onclick="gsearch()"  class="btn btn-block btn-primary">查询</button>
					                 </div>
					              </div>
							</div>

							<!--修改区域end-->
						</div>
						<!-- /.box-body -->
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="box">
								<div class="box-header">
									<h3 class="box-title">PICC穿刺维护</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body"
									style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
									<table id="newAttributeTable"
										class="table table-bordered table-hover" style="width: 100%">
										<thead>
											<tr>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
												<th></th>
											</tr>
										</thead>
									</table>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<jsp:include page="../system/foot.jsp" />
	</div>



	<form id="mform"
		action="<%=basePath%>backstage/piccMaintenanceregistration/showEdit.html"
		method="post">
		<input type="hidden" id="patientId" name="patientId" value="" /> <input
			type="hidden" id="mpunctureId" name="mpunctureId" value="" />
	</form>
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 -->
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script src="<%=basePath%>js/layer/layer.js"></script>

	<script id="tpl" type="text/x-handlebars-template">
    <div class="btn-group">
  		<button type="button" class="btn btn-sm btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
   		 操作 <span class="caret"></span>
  		</button>
  		<ul class="dropdown-menu"> 
		{{#each func}}
		<li><a href="#" onclick="{{this.fn}}">{{this.name}}</a></li>
    	{{/each}}
  		</ul>
	</div>
	</script>

	<script>
 $(function() {
	  
	
})
 
 var test;
 var table;
 var editFlag = false;
 
$(function() {

	 var tpl = $("#tpl").html();
    //预编译模板
    var template = Handlebars.compile(tpl);
	 
	 table = $('#newAttributeTable').dataTable( { 
		 "processing": true, 
		 "serverSide": true,
		 "searchable": true,
		 "searching": true,
		 "bAutoWidth" : true, //是否自适应宽度
		 "bFilter" : false,
		 "drawCallback": function( settings ) {
			  
	     },
		 "aaSorting" : [[1, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/piccMaintenanceregistration/getDate.html",
								"columns" : [
										{
											"data" : null,
											"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
											"createdCell" : function(nTd,
													sData, oData, iRow, iCol) {
												var startnum = this.api()
														.page()
														* (this.api().page
																.info().length);
												$(nTd)
														.html(
																"<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
											}
										}, {
											"data" : "createdate",
											"title" : "登记时间"
										}, {
											"data" : "hospitalnumber",
											"title" : "住院号"
										}, {
											"data" : "clinicnumber",
											"title" : "门诊号"
										}, {
											"data" : "patient",
											"title" : "病人姓名"
										}, {
											"data" : "ward",
											"title" : "所在病区"
										}, {
											"data" : "bedNo",
											"title" : "床号"
										}, {
											"data" : "maintainPeople",
											"title" : "维护护士"
										}, {
											"data" : null,
											"title" : "操作"
										} ],
								"columnDefs" : [
										{
											"bSortable" : false,
											"aTargets" : [ 0 ]
										}, //不排序的列
										{
											"targets" : [ 1 ],
											"render" : function(data, type,
													row, meta) {
												return timeForm(data);
											}
										},
										{
											targets : 8,
											render : function(data, type, row,
													meta) {
												var context = {
													func : [
															{
																"name" : "修改",
																"fn" : "edit(\'"
																		+ row.patientId
																		+ "\',\'"
																		+ row.fuid
																		+ "\')",
																"type" : "primary"
															},
															{
																"name" : "删除",
																"fn" : "del(\'"
																		+ row.fuid
																		+ "\')",
																"type" : "danger"
															}

													]
												};

												var html = template(context);
												return html;
											}
										}, ],
								"language" : {
									"lengthMenu" : "_MENU_ 条记录每页",
									"zeroRecords" : "没有找到记录",
									"info" : "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
									"infoEmpty" : "无记录",
									"infoFiltered" : "(从 _MAX_ 条记录过滤)",
									"paginate" : {
										"previous" : "上一页",
										"next" : "下一页"
									},
									"search" : " _INPUT_"
								},
								initComplete : function() {
								}
							});

			$("input[type=search]").css("display", "none");
		})

		/**
		 *编辑方法
		 **/
		function edit(patid, fuid) {
			$("#patientId").val(patid);
			$("#mpunctureId").val(fuid);
			$("#mform").submit();
		}

		function changeAll() {
			if ($("#changeAll").is(':checked')) {
				$("input[name='_change']").each(function() {
					$(this).prop("checked", "checked");
				})
			} else {
				$("input[name='_change']").each(function() {
					$(this).removeAttr("checked");
				})
			} 
		}
		function gsearch() {
			var partial = $("#partial option:selected").val();
			var ward = $("#ward").val();
			var clinicnumber = $("#clinicnumber").val();
			var patient = $("#patient").val();
			var maintainPeople = $("#maintainPeople").val();
			var stime = $("#sstime").val();
			var etime = $("#setime").val();
			var hospitalnumber=$("#hospitalnumber").val();
			var data = partial + "," + ward + "," + clinicnumber + ","
					+ patient + "," + stime + "," + etime + ","
					+ maintainPeople+","+hospitalnumber+",tt";
			table.fnFilter(data); 
		}

		//时间格式化
		function timeForm(date) {
			var bdate = new Date(date);
			var m = bdate.getMinutes().toString();
			m = m.length == 1 ? "0" + m.toString() : m;
			var h = bdate.getHours().toString();
			h = h.length == 1 ? "0" + h.toString() : h;
			var s = bdate.getSeconds().toString();
			s = s.length == 1 ? "0" + s.toString() : s;
			var d = bdate.getDate().toString();
			d = d.length == 1 ? "0" + d.toString() : d;
			var mm = (bdate.getMonth() + 1).toString();
			mm = mm.length == 1 ? "0" + mm.toString() : mm;
			bdate = bdate.getFullYear() + "-" + mm + "-" + d + " " + h + ":"
					+ m + ":" + s;
			return bdate;
		}
		
		 /**
	     * 删除数据
	     * @param name
	     */
	    function del(fuid) {
	    	if (!confirm("确认要删除？")) {
	            return;
	        }
	        $.ajax({
	            url: "<%=basePath%>backstage/piccMaintenanceregistration/delete.html",
	            data: {
	                "fuid": fuid
	            }, success: function (data) {
	            	table.api().ajax.reload(null, false); 
	            }
	        });
	    }
	    
	</script>

</body>
</html>

