<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>登录</title>

<link rel="stylesheet" href="css/jquery.ui.all.css" type="text/css"></link>
<link rel="stylesheet" href="css/demo.css" type="text/css"></link>
<link rel="stylesheet" href="css/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="css/icon.css" type="text/css"></link>
<link rel="stylesheet" href="css/style_log.css" type="text/css"></link>
<link rel="stylesheet" href="css/style.css" type="text/css"></link>
<link rel="stylesheet" href="css/userpanel.css" type="text/css"></link>
<script type="text/javascript" src="js/JQuery.cookie.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/webtemples.js"></script>
</head>
<body class="login" mycollectionplug="bind">
	<div class="login_m">
		<div class="login_logo">
			<h1>画室管理系统登录页面</h1>
		</div>
		<div class="login_boder">
			<div class="login_padding" id="login_model">
				<form action="login.action" method="post">
					<h2>USERNAME</h2>
					<label> <input type="text" name="username"
						class="txt_input txt_input2"
						onfocus="if (value ==&#39;Your name&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;Your name&#39;}"
						value="Your name" />
					</label>
					<h2>PASSWORD</h2>
					<label> <input type="password" name="password"
						class="txt_input"
						onfocus="if (value ==&#39;******&#39;){value =&#39;&#39;}"
						onblur="if (value ==&#39;&#39;){value=&#39;******&#39;}"
						value="******" />
					</label> <input type="submit" value="登录" /> &nbsp;&nbsp;&nbsp;&nbsp; <input
						type="reset" value="重填" />
				</form>
			</div>
	</div>
</body>
</html>