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
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<title>市一医院 | PICC系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<style>
    .color-palette {
      height: 35px;
      line-height: 35px;
      text-align: center;
    }

    .color-palette-set {
      margin-bottom: 15px;
    }

    .color-palette span {
      display: block;
      font-size: 12px;
    }

    .color-palette:hover span {
      display: block;
    }

    .color-palette-box h4 {
      position: absolute;
      top: 100%;
      left: 25px;
      margin-top: -40px;
      color: rgba(255, 255, 255, 0.8);
      font-size: 12px;
      display: block;
      z-index: 7;
    }
  </style>
   <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/select2/select2.min.css">
</head> 
<body class="skin-blue layout-top-nav">	
	<div class="wrapper"> 

		<c:import url="/system/menuDataTop.html"></c:import>
		<!-- Content Wrapper. Contains page content -->	 
		<div class="content-wrapper">
		<div class="container"> 
			<section class="content">
      <!-- COLOR PALETTE -->
      <div class="box box-default color-palette-box">
        <div class="box-header with-border">
          <h3 class="box-title"><i class="fa fa-tag"></i>病区病人</h3> 
        </div>
        
        <div class="box-body">
         
        <div class="row" style="margin-left: 5px;margin-bottom: 15px">
                <input id="clinicnumber" name="clinicnumber" type="text" value=""   />
       	 </div>
          <div class="row" id="con">
          	 
            
          </div>
        </div>
        <!-- /.box-body -->
      </div> 
      <form id="mform" action="<%=basePath%>backstage/piccPunctureregister/showEdit.html" method="post">
      	<input type="hidden" id="patientId" name="patientId" value="" /> 
      </form>

    </section>
			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="foot.jsp" />
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/select2/select2.full.min.js"></script>
	<script type="text/javascript">
	
	$(function() { 
		document.getElementById("clinicnumber").focus();
	 	/* $("#clinicnumber").keydown(function(){
	 		console.log($(this).length);
	 		if($(this).length==11){ 
	 			alert($(this).val());
	 		}
	 	}); */
	 	
		$("#clinicnumber").on('input propertychange',function(){
             var result = $(this).val();
             if(result.length==9){ 
            	 getPatient(result);
 	 		} 
         }); 
		 
		  
	})
	 
	function getPatient(mznum){
		$.ajax({
    		url:"<%=basePath%>/backstage/piccMaintenanceregistration/getPatient.html",
    		data:{"mznum":mznum},
    		method:"post",
    		dataType:"json",
    		success:function(res){
    			var ht="";
    			ht+="<div class='col-sm-4 col-md-2' onclick=showPatient('"+res.fuid+"')>";
    			ht+='<div class="color-palette-set">';
    			ht+='<div class="bg-green disabled color-palette"><span>门诊号：'+res.clinicnumber+'</span></div>';
    			ht+='<div class="bg-green color-palette"><span>姓名：'+res.patient+'&nbsp;'+res.sex+'</span></div>';
    			var phone=res.phone;
    			phone=phone!=null?phone:"";
    			ht+=' <div class="bg-green-active color-palette"><span>'+phone+'</span></div>';
    			ht+='</div>';
    			ht+='</div>';
    			$("#con").html(ht);
    		}
		})	
	}
	function showPatient(patid){
		$("#patientId").val(patid);
		$("#mform").submit();
	}
	</script>  
</body>
</html>
