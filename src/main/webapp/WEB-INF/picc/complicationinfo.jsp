 
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
<title>云管理 | 管理</title>
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
					市一医院 <small>并发症维护</small>
				</h1>
			</section>
 
			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">并发症列表</h3>
								<div class="ibox-tools rboor">
			                        <a href="javascript:add()" class="btn btn-primary btn-xs p310"  ><i class="fa fa-plus"></i> 新增</a> 
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
							<dt>infusionTool</dt>
							<dd id="d_infusionTool"></dd>
							<dt>parts</dt>
							<dd id="d_parts"></dd>
							<dt>typeId</dt>
							<dd id="d_typeId"></dd>
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
        "ajax": "<%=basePath%>backstage/piccComplicationinfo/getDate.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page() 
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "infusionTool",
								"title" : "输液工具" },
						  { "data": "parts",
								"title" : "发生部位" },
								 { "data": "createdate",
									"title" : "创建时间" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,4 ] },   //不排序的列
					{ 
						  targets: 2,
						  render: function(data,type,row,meta){ 
							  if(data!=null&&data.length>15){ 
								  data=data.substring(0,15)+"...";
							  }
							  return data;
						  }
					}, 
					{ "bSortable": false, "aTargets": [ 0 ] },   //不排序的列
					  { 
						  targets: 3,
						  render: function(data,type,row,meta){ 
							  return timeForm(data);
						  }
					  }, 
					  {
	                        targets:4, 
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
	 
	 
	 $("input[type=search]").attr("placeholder","请输入名称");
 })

 	 
 	/**
     * 添加数据
     **/
    function add(id) {
		 window.location.href="<%=basePath%>backstage/piccComplicationinfo/showEdit.html";
    }

    /**
     *编辑方法  
     **/
    function edit(fuid) {
    	 window.location.href="<%=basePath%>backstage/piccComplicationinfo/showEdit.html?id="+fuid;
    }

    /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='createdate']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='infusionTool']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='parts']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='typeId']").val().length == 0){
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
            url: "<%=basePath%>backstage/piccComplicationinfo/delete.html",
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
	 		url:"<%=basePath%>backstage/piccComplicationinfo/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.piccComplicationinfo;
	 				$("#d_fuid").html(s.fuid);  
	 				$("#d_createdate").html(s.createdate);  
	 				$("#d_infusionTool").html(s.infusionTool);  
	 				$("#d_parts").html(s.parts);  
	 				$("#d_typeId").html(s.typeId);  
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
	 
