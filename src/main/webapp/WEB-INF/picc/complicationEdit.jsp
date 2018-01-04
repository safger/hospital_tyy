<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
									<h3 class="box-title">穿刺登记</h3>
								</div>
								<div class="box-body">
								<form action="" method="post" id="myform">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th colspan="10">病人信息</th>
												<input   type="hidden" value="${tyyPatient.fuid }" name="patientId" /> 
												<input   type="hidden" value="${piccComplication.fuid }" name="fuid" />
											</tr>
										</thead> 
										<tbody> 
											<tr>
												<td class="active">住院号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.hospitalnumber }"  /></td>
												<td class="active">门诊号</td>
												<td><input readonly="readonly" type="text"  /></td>
												<td class="active">病人姓名</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.patient }"   /></td>
												<td class="active">性别</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.sex }"  /></td>
												<td class="active">年龄</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.age }"  /></td>
											</tr>
											<tr>
												<td class="active">床号</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.bedNo }"  /></td>
												<td class="active">病区</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.ward }"  /></td>
												<td class="active">科室</td>
												<td><input readonly="readonly" type="text"
													value="${tyyPatient.department }"  /></td>
												<td class="active">联系电话</td>
												<td colspan="3"><input readonly="readonly" type="text"
													value="${tyyPatient.phone }"   /></td>
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
												<th colspan="10">并发症信息</th>
											</tr>
											<tr>
												<td class="active">输液工具</td>
												<td colspan="9">   
												<div class="btn-group" data-toggle="btn-toggle">
													 <c:forEach items="${info_list }" var="list" >
														<button onclick="act('${list.parts}','${list.fuid}','${list.infusionTool}')" type="button" class="btn btn-default btn-sm">${list.infusionTool}  </button>
													</c:forEach>   
													<input type="hidden" name="infusionTool" value="" /> 
													<input type="hidden" name="parts" value="" />
               									</div>  
												</td>    
											</tr>
											 <tr>
												<td class="active">发生部位</td>
												<td colspan="9"> 
													<div class="btn-group" id="fsbw" data-toggle="btn-toggle">
               										</div>  
												</td>
											</tr>
											  <tr>
												<td class="active">并发症类型</td>
												<td colspan="9" id="bfz">  
												</td> 
											</tr>
											  <tr>
												<td class="active">补充信息</td>
												<td colspan="9"> 
												<input type="text" value="" name="supplement">
												</td>
											</tr>
											<tr>
												<th colspan="10">医务人员信息</th>
											</tr>
											<tr>
												<td class="active">申请人姓名</td>
												<td><input type="text" value="${piccComplication.sapplicant }" name="sapplicat" /> </td>
												<td class="active">申请人代码</td>
												<td><input type="number" value="${piccComplication.applicantCode }"
													name="applicantCode" /></td>
												<td class="active">申请科室</td>
												<td colspan="3"><input type="text" value="${piccComplication.department }" name="department" /></td>
												<td class="active">手机短号</td>
												<td colspan="1"><input type="text" value="${piccComplication.trumpet }"
													name="trumpet" /></td>
											</tr>
											<tr> 
												<td class="active">邀请科室</td>
												<td colspan="3"><input type="text"   value="${piccComplication.invitation }" name="invitation" />
												</td> 
												<td class="active">邀请时间</td>
												<td colspan="5"><input type="text" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" value="<fmt:formatDate value="${piccComplication.invitationTime}" pattern="yyyy-MM-dd HH:mm"/>"
													name="InvitationTime" /></td> 
											</tr>
											 <tr>
												<td class="active">是否需要会诊</td>
												<td colspan="9"> 
												<input name="hisConsultation" value="0" checked="checked" type="radio" class="minimal" > 否
												<input name="hisConsultation" value="1"   type="radio" class="minimal" > 是
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
			 
			var punctureCauses='${piccComplication.punctureCauses }'; 
			if(punctureCauses.length>0){
				$("select[name='punctureCauses']").val(punctureCauses);
			}
			var punctureMethod='${piccComplication.punctureMethod }';
			if(punctureMethod.length>0){ 
				$("select[name='punctureMethod']").val(punctureMethod);
			} 
			var catheter='${piccComplication.catheter }';
			if(catheter.length>0){
				$("select[name='catheter']").val(catheter);
			} 
			var specification='${piccComplication.specification }';
			if(specification.length>0){
				$("select[name='specification']").val(specification);
			} 
			var punctureSite='${piccComplication.punctureSite }';
			if(punctureSite.length>0){
				$("select[name='punctureSite']").val(punctureSite);
			}  
			var punctureVein='${piccComplication.punctureVein }';
			if(punctureVein.length>0){
				$("select[name='punctureVein']").val(punctureVein);
			} 
			var measuring='${piccComplication.measuring }';
			if(measuring.length>0){
				$("select[name='measuring']").val(measuring);
			} 
			var cendPosition='${piccComplication.cendPosition }';
			if(cendPosition.length>0){
				$("select[name='cendPosition']").val(cendPosition); 
			} 
			var qexception='${piccComplication.qexception }';
			if(qexception.length>0){
				$("select[name='qexception']").val(qexception);
			} 
			
			
		})
		 
		
		function sub(){
			var infusionTool=$("input[name='infusionTool']").val();
			var parts=$("input[name='parts']").val();
			var btype=$("input[name='btype']:checked");
			if(infusionTool.length==0){
				 layer.msg("请选择输液工具");
					return;
			}
			if(infusionTool!='输液港'){
				if(parts==null){
					 layer.msg("请选择发送部位");
					return;
				}
				if(btype!=null&&btype.length==0){
					 layer.msg("请选择并发症类型");
					return;
				}
			}
			$("#myform").attr("action","<%=basePath%>backstage/piccComplication/edit.html");
			$("#myform").submit();
			 
		} 
		
		function act(parts,fuid,name){ 
			var ht="";
			  $.ajax({
		            url: "<%=basePath%>backstage/piccComplication/complication.html",
			 		type: 'post',
			 		data:{"fuid":fuid}, 
			 		dataType:"json",
			 		success: function (data) {
		            	 if(data!=null&&data.length>0){
		            		 var tt=''; 
		            		 for(var a=0;a<data.length;a++){ 
		            			 tt+=' <input name="btype" value="'+data[a].name+'" type="checkbox" class="minimal" > '+data[a].name;
		            		 }
		            		 $("#bfz").html(tt);
		            		  
		            		 $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
		       			      checkboxClass: 'icheckbox_minimal-blue',
		       			      radioClass: 'iradio_minimal-blue'
		       			    });
		       			  
		            	 }else{
		            		 $("#bfz").html("");
		            	 }
		            }
		        });
			
			
			if(parts.length>0){
				var pa=parts.split("&");
				for(var a=0;a<pa.length;a++){
					ht+='<button onclick="cssAction(this,&apos;'+pa[a]+'&apos;)" name="part"  type="button" class="btn btn-default btn-sm">'+pa[a]+'</button>';
				}
			}
			$("#fsbw").html(ht);
			$("input[name='infusionTool']").val(name);
		} 
		  
		function cssAction(obj,da){  
			$("button[name='part']").each(function (){
				$(this).attr("class","btn btn-default btn-sm");
			})
			$(obj).attr("class","btn btn-default btn-sm active");
			$("input[name='parts']").val(da);
		}
	</script>
</body>
</html>
