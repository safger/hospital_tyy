 
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
<body class="skin-blue layout-top-nav"> 
	<div class="wrapper">

		<c:import url="/system/menuDataTop.html"></c:import>
		
		
		<div class="content-wrapper">
			<div class="container">

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
								<label for="exampleInputEmail1">fuid </label> <input type="text" class="form-control" id="fuid" name="fuid" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">modifydate </label> <input type="text" class="form-control" id="modifydate" name="modifydate" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">name </label> <input type="text" class="form-control" id="name" name="name" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">sex </label> <input type="text" class="form-control" id="sex" name="sex" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">birthday </label> <input type="text" class="form-control" id="birthday" name="birthday" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">pinying </label> <input type="text" class="form-control" id="pinying" name="pinying" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">ysdm </label> <input type="text" class="form-control" id="ysdm" name="ysdm" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">department </label> <input type="text" class="form-control" id="department" name="department" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">dcode </label> <input type="text" class="form-control" id="dcode" name="dcode" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">expert </label> <input type="text" class="form-control" id="expert" name="expert" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">phone </label> <input type="text" class="form-control" id="phone" name="phone" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">clinicTime </label> <input type="text" class="form-control" id="clinicTime" name="clinicTime" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">job </label> <input type="text" class="form-control" id="job" name="job" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">position </label> <input type="text" class="form-control" id="position" name="position" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">expertFee </label> <input type="text" class="form-control" id="expertFee" name="expertFee" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">clinicAddress </label> <input type="text" class="form-control" id="clinicAddress" name="clinicAddress" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">education </label> <input type="text" class="form-control" id="education" name="education" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">photo </label> <input type="text" class="form-control" id="photo" name="photo" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">avatar </label> <input type="text" class="form-control" id="avatar" name="avatar" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">introduction </label> <input type="text" class="form-control" id="introduction" name="introduction" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">research </label> <input type="text" class="form-control" id="research" name="research" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">attack </label> <input type="text" class="form-control" id="attack" name="attack" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">results </label> <input type="text" class="form-control" id="results" name="results" placeholder="">
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
							<dt>modifydate</dt>
							<dd id="d_modifydate"></dd>
							<dt>name</dt>
							<dd id="d_name"></dd>
							<dt>sex</dt>
							<dd id="d_sex"></dd>
							<dt>birthday</dt>
							<dd id="d_birthday"></dd>
							<dt>pinying</dt>
							<dd id="d_pinying"></dd>
							<dt>ysdm</dt>
							<dd id="d_ysdm"></dd>
							<dt>department</dt>
							<dd id="d_department"></dd>
							<dt>dcode</dt>
							<dd id="d_dcode"></dd>
							<dt>expert</dt>
							<dd id="d_expert"></dd>
							<dt>phone</dt>
							<dd id="d_phone"></dd>
							<dt>clinicTime</dt>
							<dd id="d_clinicTime"></dd>
							<dt>job</dt>
							<dd id="d_job"></dd>
							<dt>position</dt>
							<dd id="d_position"></dd>
							<dt>expertFee</dt>
							<dd id="d_expertFee"></dd>
							<dt>clinicAddress</dt>
							<dd id="d_clinicAddress"></dd>
							<dt>education</dt>
							<dd id="d_education"></dd>
							<dt>photo</dt>
							<dd id="d_photo"></dd>
							<dt>avatar</dt>
							<dd id="d_avatar"></dd>
							<dt>introduction</dt>
							<dd id="d_introduction"></dd>
							<dt>research</dt>
							<dd id="d_research"></dd>
							<dt>attack</dt>
							<dd id="d_attack"></dd>
							<dt>results</dt>
							<dd id="d_results"></dd>
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

 var page=0;
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
		 "aaSorting" : [[1, "asc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/doctors/getDate.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "name",
								"title" : "姓名" },
						  { "data": "sex",
								"title" : "性别" },
						  { "data": "department",
								"title" : "科室" },
						  { "data": "expert",
								"title" : "是否专家" },
						  { "data": "phone",
								"title" : "手机" },
						  { "data": "job",
								"title" : "职称" },
						  { "data": "expertFee",
								"title" : "专家费" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0 ] },   //不排序的列
					{ 
					    "targets": [1],  
					    "render": function (data,type, row,   meta) { 
					    	 if(row.hardwareInfo!=null){
						         return '<a href=javascript:showDetail("'+row.fuid+'")>'+data+'</a>';
					    	 }else{
					    		 return data;  
					    	 }	 
					    }  
					},
					 {  
                        targets:4, 
                        render: function (data, type, row,   meta) {
							if(data==1){
								return "是";
							}else{
								return "否";
							}                            
                        }
                    },
					  {  
	                        targets:8, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {
	                            		 func: [
	   	                                    {"name": "修改","fn": "edit(\'" + row.fuid + "\',\'" + page + "\')", "type": "primary"},
	   	                                    {"name": "删除", "fn": "del(\'" + row.fuid + "\',\'" + page + "\')", "type": "danger"}
	   	                                   
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
            		var hpage='${page}';
            		if(hpage!='null'&&hpage>0){
                        $('#newAttributeTable').dataTable().fnPageChange( parseInt(hpage) );
                    }
                }
     } );
	 
	 $("#save").click(add);
	 
	 $("input[type=search]").attr("placeholder","请输入姓名或医生代码");




    $('#newAttributeTable').on( 'page.dt', function () {
        var tableSetings=$('#newAttributeTable').dataTable().fnSettings()
        var paging_length=tableSetings._iDisplayLength;//当前每页显示多少
        var page_start=tableSetings._iDisplayStart;//当前页开始
		page=Div(page_start,paging_length);
    } );

})
 function Div(exp1, exp2) {  //整除
     var n1 = Math.round(exp1); //四舍五入
     var n2 = Math.round(exp2); //四舍五入

     var rslt = n1 / n2; //除
     if (rslt >= 0) {
         rslt = Math.floor(rslt); //返回小于等于原rslt的最大整数。
     }
     else {
         rslt = Math.ceil(rslt); //返回大于等于原rslt的最小整数。
     }
     return rslt;
 }
 	 
 	/**
     * 添加数据
     **/
    function add() {
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"/backstage/doctors/edit.html",
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
    function edit(fuid,page) {
    	 window.location.href="<%=basePath%>backstage/doctors/showEdit.html?id="+fuid+"&page="+page;
    }

    /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='modifydate']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='name']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='sex']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='birthday']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='pinying']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='ysdm']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='department']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='dcode']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='expert']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='phone']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='clinicTime']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='job']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='position']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='expertFee']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='clinicAddress']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='education']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='photo']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='avatar']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='introduction']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='research']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='attack']").val().length == 0){
		 layer.msg("请输入值");
		 t=false;
	  } 
	  if($("input[name='results']").val().length == 0){
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
            url: "<%=basePath%>backstage/doctors/delete.html",
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
	 		url:"<%=basePath%>backstage/doctors/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.doctors;
	 				$("#d_fuid").html(s.fuid);  
	 				$("#d_modifydate").html(s.modifydate);  
	 				$("#d_name").html(s.name);  
	 				$("#d_sex").html(s.sex);  
	 				$("#d_birthday").html(s.birthday);  
	 				$("#d_pinying").html(s.pinying);  
	 				$("#d_ysdm").html(s.ysdm);  
	 				$("#d_department").html(s.department);  
	 				$("#d_dcode").html(s.dcode);  
	 				$("#d_expert").html(s.expert);  
	 				$("#d_phone").html(s.phone);  
	 				$("#d_clinicTime").html(s.clinicTime);  
	 				$("#d_job").html(s.job);  
	 				$("#d_position").html(s.position);  
	 				$("#d_expertFee").html(s.expertFee);  
	 				$("#d_clinicAddress").html(s.clinicAddress);  
	 				$("#d_education").html(s.education);  
	 				$("#d_photo").html(s.photo);  
	 				$("#d_avatar").html(s.avatar);  
	 				$("#d_introduction").html(s.introduction);  
	 				$("#d_research").html(s.research);  
	 				$("#d_attack").html(s.attack);  
	 				$("#d_results").html(s.results);  
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
	 
