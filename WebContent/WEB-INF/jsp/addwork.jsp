<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addparent.jsp' starting page</title>
    
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
  </head>
  
  <body>
  <form action="manager/student/addWork.action" method="post" enctype="multipart/form-data">
  	<input type="hidden" name="s_id" value="${s_id }"/>
  	<table border="1">
  		<tr>
  		<td>作品名<font color="red">(*)</font>：</td>
  		<td><input type="text" name="name"/></td>
  		</tr>
  		<tr>
  		<td>评语：</td>
  		<td><textarea name="w_comment" cols="19" rows="3"></textarea></td>
  		</tr>
  		<tr>
  		<td>发布时间<font color="red">(*)</font>：</td>
  		<td><input id="dd" name="pubtime" class="easyui-datebox"></input></td>
  		</tr>
  		<tr>
  		<td>图片<font color="red">(*)</font>：</td>
  		<td>
  			<input type="file" name="file">
  		</td>
  		</tr>
  	</table>
  	<input type="submit" value="提交"/>
  </form>
  </body>
</html>
