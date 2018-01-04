<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>版本过低</title>
<link href="<%=basePath %>source/jump/css/index.css" rel="stylesheet" /><!-- 样式 -->
</head>

<body style="background:#fff;">
	<div id="no-support"> 
   	 <h4>请选择一款浏览器</h4>
    	<h5>系统检测发现您正在使用低版本浏览器，请点击下面的chrome下载并安装新版本浏览器</h5>
    <ul>
        <li class=ff><a href="http://172.16.0.8/Firefox.exe" target=_blank><span>firefox</span></a></li>
        <li class=ie><a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie" target=_blank><span>ie11</span></a></li>
        <li class=chrome><a href="http://172.16.0.8/ChromeStandalone.exe" target=_blank><span>chrome</span></a></li>
        <li class=jisu360><a href="http://chrome.360.cn/" target=_blank><span>360极速</span></a></li>
        <div class=clear></div>
    </ul> 
    	<div class=clear></div>
    </div> 
    <div class="tip" style="bottom: 15%"> 
    	<p>微软官方宣布自2016年1月12日起微软将停止支持旧版的IE浏览器（IE6/7/8/9/10）</p>
        <p>淘宝网在2016年4月也正式停止对IE6浏览器的支持，停止支持的还包括同样老古董的IE7</p>
    </div>
</body>
</html>

