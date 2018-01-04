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
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%=basePath%>source/guide/style.css">
    <style type="text/css">
        html,body{
            height: 100%;
            width: 100%;
            overflow: hidden;
        }
    </style>
    <!-- <script src="<%=basePath%>source/guide/Respond.js"></script> -->
    <!--[if lt IE 9]>
        <script src="<%=basePath%>source/guide/Respond.js"></script>
    <![endif]-->
    <title>系统选择</title>
    
    <!--[if IE 6]>
        <script src="<%=basePath%>source/guide/DDPngMin.js"></script>
        <script>
        window.onload=function(){
            DD_belatedPNG.fix('.logo img,.picSign img,.wrapper .itemList,.wrapper li div, .wrapper li div img');
        }
      </script>
    <![endif]--> 
</head>
<body class="choose"> 
    <div class="box">
       <div class="inner">
            <div class="logo"><img src="<%=basePath%>source/guide/img/logo.png" ></div>
            <div class="wrapper">
                <div class="picSign"><img src="<%=basePath%>source/guide/img/center.png" width="100%"></div>
                <div class="itemList">
                    <ul>
                       <%--  <li>
                            <a>
                                <div class="color1"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>系统一系统一系统一系统一</p>
                            </a>
                        </li>
                        <li>
                            <a>
                                <div class="color2"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>系统一系统一系统一</p>
                            </a>
                        </li>
                        <li>
                            <a>
                                <div class="color3"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>系统一系统一</p>
                            </a>
                        </li>--%>
                        <li>
                            <a>
                                <div class="color4"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>居家护理管理系统</p>
                            </a>
                        </li> 
                        <li>
                            <a>
                                <div class="color5" onclick="sub(5)"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>门诊排班考勤系统</p>
                            </a>
                        </li>
                        <li>
                            <a>
                                <div onclick="sub(6)" class="color6"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>PICC管理系统</p>
                            </a>
                        </li>
                        <li>
                            <a>
                                <div class="color7" onclick="sub(7)"><span><img src="<%=basePath%>source/guide/img/icon1.png"></span></div>
                                <p>用药错误管理系统</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- <div class="footer">copyright @2017 台州市第一人民医院</div>
       </div> -->
    </div>
    <form method="post" id="myform" action="<%=basePath%>system/login.html">
    	<input type="hidden" name="sysname" value="" />
    </form>
</body>
<script src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

	function sub(n){
		switch(n)
		{
		case 6:
			$("input[name='sysname']").val("PICC系统");
			$("#myform").submit();
		  break;
		case 5:
			window.open("http://172.16.0.68:8080/system/login.html");
		case 7:
			$("input[name='sysname']").val("用药错误系统");
			$("#myform").submit();
		  break;
		}
		
	}
	
	$(function() {
		
		BrowserType();
		
	})
	function BrowserType() {
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		var isOpera = userAgent.indexOf("Opera") > -1; //判断是否Opera浏览器
		var isIE = userAgent.indexOf("compatible") > -1
				&& userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
		var isEdge = userAgent.indexOf("Windows NT 6.1; Trident/7.0;") > -1
				&& !isIE; //判断是否IE的Edge浏览器
		var isFF = userAgent.indexOf("Firefox") > -1; //判断是否Firefox浏览器
		var isSafari = userAgent.indexOf("Safari") > -1
				&& userAgent.indexOf("Chrome") == -1; //判断是否Safari浏览器
		var isChrome = userAgent.indexOf("Chrome") > -1
				&& userAgent.indexOf("Safari") > -1; //判断Chrome浏览器

		if (isIE) {
			var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
			reIE.test(userAgent);
			var fIEVersion = parseFloat(RegExp["$1"]);
			if (fIEVersion == 7) {
				window.location.href="<%=basePath%>system/jump.html";
				return "IE7";
			} else if (fIEVersion == 8) {
				window.location.href="<%=basePath%>system/jump.html";
				return "IE8";
			} else if (fIEVersion == 9) {
				return "IE9";
			} else if (fIEVersion == 10) {
				return "IE10";
			} else if (fIEVersion == 11) { 
				return "IE11";
			} else {
				window.location.href="<%=basePath%>system/jump.html";
				return "0"
			}//IE版本过低
		}//isIE end

		if (isFF) {
			return "FF";
		}
		if (isOpera) {
			return "Opera";
		}
		if (isSafari) {
			return "Safari";
		}
		if (isChrome) {
			return "Chrome";
		}
		if (isEdge) {
			return "Edge";
		}
	}//myBrowser() end

	//判断是否是IE浏览器
	function isIE() {
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		var isIE = userAgent.indexOf("compatible") > -1
				&& userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
		if (isIE) {
			return "1";
		} else {
			return "-1";
		}
	}

	//判断是否是IE浏览器，包括Edge浏览器
	function IEVersion() {
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		var isIE = userAgent.indexOf("compatible") > -1
				&& userAgent.indexOf("MSIE") > -1 && !isOpera; //判断是否IE浏览器
		var isEdge = userAgent.indexOf("Windows NT 6.1; Trident/7.0;") > -1
				&& !isIE; //判断是否IE的Edge浏览器
		if (isIE) {
			var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
			reIE.test(userAgent);
			var fIEVersion = parseFloat(RegExp["$1"]);
			if (fIEVersion == 7) {
				return "IE7";
			} else if (fIEVersion == 8) {
				return "IE8";
			} else if (fIEVersion == 9) {
				return "IE9";
			} else if (fIEVersion == 10) {
				return "IE10";
			} else if (fIEVersion == 11) {
				return "IE11";
			} else {
				return "0"
			}//IE版本过低
		} else if (isEdge) {
			return "Edge";
		} else {
			return "-1";//非IE
		}
	}
</script>

</html>
