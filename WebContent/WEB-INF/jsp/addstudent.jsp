<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addstudent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.min.js">
	
</script>
<script type="text/javascript" src="js/jquery.easyui.min.js">
	
</script>
<link rel="stylesheet" type="text/css" href="css/easyui.css">
<link rel="stylesheet" type="text/css" href="css/icon.css">
<link rel="stylesheet" type="text/css" href="css/default/calendar.css">
<script type="text/javascript" src="easyui-lang-zh_CN.js"></script>
</html>
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/${url }"
		class="easyui-form" method="POST" id="userForm">
		<table border="1">
			<tr>
				<td>姓名:<font color="red">(*)</font>
				</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>性别:<font color="red">(*)</font>
				</td>
				<td><input type="radio" name="sex" value="男">男</input> 
					<input type="radio" name="sex" value="女">女</input> 
				</td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input name="age" /></td>
			</tr>
			<tr>
				<td>生日:<font color="red">(*)</font>
				</td>
				<td><input id="dd" name="brithday" class="easyui-datebox"
					></input><font color="red">日期格式:MM/dd/yyyy，可以手动填写</font></td>
			</tr>
			<tr>
				<td>学校:</td>
				<td><input name="school" type="text" /></td>
			</tr>
			<tr>
				<td>班级:</td>
				<td><input name="classroom" type="text" /></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>
