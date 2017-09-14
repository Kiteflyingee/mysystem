<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="zh">

<head>
<base href="<%=basePath%>">
<%@include file="/common/easyuicommon.jspf"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="${mypath }/css/styles.css">
</head>
<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>登录界面</h1>
			
			<form class="form" method="post">
				<input type="text" name="username" placeholder="用户名">
				<input type="password" name="password" placeholder="密码">
				<button type="submit" id="login-button">登录</button>
			</form>
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>

<script src="${mypath }/js/jquery.min.js" type="text/javascript"></script>
<script>
$('#login-button').click(function (event) {
	event.preventDefault();
	$('form').fadeOut(500);
	$('.wrapper').addClass('form-success');
	$('form').attr("action","${mypath}/login.action");
	$('form').submit();
	
});
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
<h1>艺柒画室管理系统</h1>
</div>
</body>
</html>