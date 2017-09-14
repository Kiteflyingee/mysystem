<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentdetail.jsp' starting page</title>
    
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
   	<table border="1" width="300" height="300">
   		<tr>
   			<td>学生名:</td>
   			<td>${student.name }</td>
   		</tr>
   		<tr>
   			<td>性别:</td>
   			<td>${student.sex }</td>
   		</tr>
   		<tr>
   			<td>年龄:</td>
   			<td>${student.age }</td>
   		</tr>
   		<tr>
   			<td>生日:</td>
   			<td><fmt:formatDate pattern="yyyy年MM月"
						value="${student.brithday }" /></td>
   		</tr>
   		<tr>
   			<td>学校:</td>
   			<td>${student.school }</td>
   		</tr>
   		<tr>
   			<td>班级:</td>
   			<td>${student.classroom }</td>
   		</tr>
		<tr>
   			<td>操作:</td>
   			<td><a href="manager/student/showModifyStudent.action?id=${student.id}">修改</a></td>
   		</tr>
   	</table>
  </body>
</html>
