 
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

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
<title>市一医 | 并发症相关</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
<style>
.ibox-tools {
    display: inline-block;
    float: right;
    margin-top: 0;
    position: relative;
    padding: 0;
}
.ibox-tools a{
    cursor: pointer;
    margin-left: 5px;
} 

.btn-primary {
    background-color: #1ab394;
    border-color: #1ab394;
    color: #FFFFFF;
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
					市一医 |  <small>并发症相关</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>system/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/piccComplicationtype/show.html">管理</a></li>
					<li class="active">并发症相关列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">列表</h3>
								<div class="ibox-tools rboor">
			                        <a href="javascript:void(0)" class="btn btn-primary btn-xs p310" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 新增</a> 
			                    </div>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table id="newAttributeTable" class="table table-bordered table-hover" style="width: 100%">
									<thead>
										<tr> 
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
	 
	<!-- Modal2 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<form id="editForm">
					<div class="modal-body">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">名称 </label> <input type="text" class="form-control" id="name" name="name" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">并发症相关 </label> 
								<textarea rows="3" cols="4" class="form-control" id="symptom" name="symptom" ></textarea>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">处理 </label>
								<textarea rows="3" cols="4" class="form-control" id="process" name="process" ></textarea>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">评价 </label>
								<textarea rows="3" cols="4" class="form-control" id="evaluation" name="evaluation" ></textarea>
							</div>
						<input type="hidden" id="fuid" name="fuid">
						</div>
					</div> 
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save">保存</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal2 -->

 
	<!-- Modal detail -->
	<div class="modal fade" id="Modal_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="box-header with-border" style="border-bottom:0px">
						<button type="button" class="close" style="z-index: 1000" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<i class="fa fa-tv"></i>
						<h3 class="box-title">详情</h3>
					</div>
				</div>
				<div class="modal-body">
					<div class="panel-body" style="padding: 0px;font-size: 12px">
						<dl class="dl-horizontal">
							<dt>fuid</dt>
							<dd id="d_fuid"></dd>
							<dt>createdate</dt>
							<dd id="d_createdate"></dd>
							<dt>name</dt>
							<dd id="d_name"></dd>
							<dt>symptom</dt>
							<dd id="d_symptom"></dd>
							<dt>process</dt>
							<dd id="d_process"></dd>
							<dt>evaluation</dt>
							<dd id="d_evaluation"></dd>
						</dl>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
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
        "ajax": "<%=basePath%>backstage/piccComplicationtype/getDate.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "name",
								"title" : "名称" },
						  { "data": "symptom",
								"title" : "症状" },
						  { "data": "process",
								"title" : "处理" },
						  { "data": "evaluation",
								"title" : "评价" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0 ] },   //不排序的列
					 
					  {
                        targets:2, 
                        render: function (data, type, row,   meta) {
                            if(data!=null&&data.length>20){
                            	data=data.substring(0,20)+"...";
                            }
                            return data;
                        }
                    },
                    {
                        targets:3, 
                        render: function (data, type, row,   meta) {
                            if(data!=null&&data.length>20){
                            	data=data.substring(0,20)+"...";
                            }
                            return data;
                        }
                    },
                    {
                        targets:4, 
                        render: function (data, type, row,   meta) {
                            if(data!=null&&data.length>20){
                            	data=data.substring(0,20)+"...";
                            }
                            return data;
                        }
                    },
					  {
	                        targets:5, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {
	                            		 func: [
	   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} ,
	   	                                    {"name": "修改","fn": "edit(\'" + row.fuid + "\')", "type": "primary"},
	   	                                    {"name": "删除", "fn": "del(\'" + row.fuid + "\')", "type": "danger"}
	   	                                   
	   	                                ]
	                            };
	                            
	                            var html = template(context);
	                            return html;
	                        }
	                    },
                ],
                "language": {
                    "lengthMenu": "_MENU_ 条记录每页",
                    "zeroRecords": "没有找到记录",
                    "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 ,共 _MAX_ 条)",
                    "infoEmpty": "无记录",
                    "infoFiltered": "(从 _MAX_ 条记录过滤)",
                    "paginate": {
                        "previous": "上一页", 
                        "next": "下一页"
                    },
                    "search": " _INPUT_"
                },
                initComplete: function () {     
                }   
     } );
	 
	 $("#save").click(add);
	 
	 $("input[type=search]").attr("placeholder","请输入名称");
 })

 	 
 	/**
     * 添加数据
     **/
    function add() {
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"<%=basePath%>backstage/piccComplicationtype/edit.html",
            data: $("#editForm").serialize(),
            dataType:"json",
            type:"post",
            success: function (data) { 
            	table.api().ajax.reload(null, false); 
                $("#myModal").modal("hide");
                $("#myModalLabel").text("新增");
                clear();
            }
        });
    }

    /**
     *编辑方法
     **/
    function edit(fuid) {
    	$.ajax({
    		url:"<%=basePath%>backstage/piccComplicationtype/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		 type:"post",
    		success:function(res){
    			var s = res.data.piccComplicationtype;
    			editFlag = true;
    	        $("#myModalLabel").text("修改");
    	        $("#fuid").val(s.fuid);
    	        $("#createdate").val(s.createdate);
    	        $("#name").val(s.name);
    	        $("#symptom").val(s.symptom);
    	        $("#process").val(s.process);
    	        $("#evaluation").val(s.evaluation);
     	        $("#myModal").modal("show"); 
    		}
    	});
    }

    /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='name']").val().length == 0){
		 layer.msg("请输入值");
		 t=false; 
	  } 
	  if($("textarea[name='symptom']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  }  
	  if($("textarea[name='process']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("textarea[name='evaluation']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  return t;
    }  
    /**
     * 清除
     */ 
    function clear() {
    	$(".modal-content").find("input").each(function (){
    		$(this).val("");
    	}) 
    	$(".modal-content").find("textarea").each(function (){
    		$(this).val("");
    	})
    	
        editFlag = false;
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
            url: "<%=basePath%>backstage/piccComplicationtype/delete.html",
            data: {
                "fuid": fuid
            }, success: function (data) {
            	table.api().ajax.reload(null, false); 
            }
        });
    }
    
     
    function changeAll(){     
    	if($("#changeAll").is(':checked')){ 
    		$("input[name='_change']").each(function (){
    			$(this).prop("checked","checked");
    		})   
    	}else{  
    		$("input[name='_change']").each(function (){
    			$(this).removeAttr("checked");   
    		}) 
    	}
    }
    
    
    
    function showDetail(fuid){
		$.ajax({
	 		url:"<%=basePath%>backstage/piccComplicationtype/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.piccComplicationtype;
	 				$("#d_fuid").html(s.fuid);  
	 				$("#d_createdate").html(s.createdate);  
	 				$("#d_name").html(s.name);  
	 				$("#d_symptom").html(s.symptom);  
	 				$("#d_process").html(s.process);  
	 				$("#d_evaluation").html(s.evaluation);  
	        	//var cdate = new Date(s.createTime);
	        	//$("#d_createTime").html(cdate.getFullYear()+"-"+(cdate.getMonth()+1)+"-"+cdate.getDate());
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	} 
    
    //时间格式化
    function timeForm(date){ 
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
	</script>

</body>
</html>
	 
