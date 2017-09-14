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

  </head>
  
  <body>
  <form action="manager/student/addParent.action" method="post">
  	<input type="hidden" name="s_id" value="${s_id }"/>
  	<table border="1">
  		<tr>
  		<td>姓名<font color="red">(*)</font>：</td>
  		<td><input type="text" name="name" value="${parent.name }"/></td>
  		</tr>
  		<tr>
  		<td>关系:</td>
  		<td><input type="text" name="relation" value="${parent.relation }" /></td>
  		</tr>
  		<tr>
  		<td>手机<font color="red">(*)</font>:</td>
  		<td><input type="text" name="mobile" value="${parent.mobile }" /></td>
  		</tr>
  		<tr>
  		<td>工作:</td>
  		<td><input type="text" name="job" value="${parent.job }" /></td>
  		</tr>
  		<tr>
  		<td>公司:</td>
  		<td><input type="text" name="company" value="${parent.company }" /></td>
  		</tr>
  		<tr>
  		<td>住址:</td>
  		<td><input type="text" name="address" value="${parent.address }" /></td>
  		</tr>
  	</table>
  	<input type="submit" value="提交"/>
  </form>
  </body>
</html>
