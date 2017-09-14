<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listclazz.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <style type="text/css">
td {
	text-align: center;
	margin: auto;
}
  </style>
  <body>
  <table border="1" width="200">
  	<tr>
  		<td>课程名</td>
  		<td>课程状态</td>
  		<td>课程操作</td>
  	</tr>
  	<c:forEach items="${clazzs}" var="clazz">
  	<tr>
  		<td>${clazz.name }</td>
  		<td>
  		<c:if test="${clazz.status==1}">启用</c:if>
  		<c:if test="${clazz.status==0}">停用</c:if>
  		</td>
  		<td>
  		<!-- 功能未启用 -->
  		<c:if test="${clazz.status==1}"><a href="manager/main/changeStatus.action?id=${clazz.id }&status=0">停用</a></c:if>
  		<c:if test="${clazz.status==0}"><a href="manager/main/changeStatus.action?id=${clazz.id }&status=1">启用</a></c:if>
  		</td>
  	</tr>
  	</c:forEach>
  </table>
  </body>
</html>
