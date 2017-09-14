<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showdetail.jsp' starting page</title>
    
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
  	<!-- 这里负责目录，后期用树的形式展示 -->
  	<div id="menu">
	   	<ul>
	   		<li><a href="manager/student/showDetail.action?id=${id} " target="right">学生个人信息</a></li>
	   		
	   		<li><a href="manager/student/listParents.action?id=${id}" target="right">家长信息管理</a></li>
	   		
	   		<li><a href="manager/student/listClazzRecords.action?id=${id}" target="right">课次记录管理</a></li>
	   		
	   		<li><a href="manager/student/listWorks.action?s_id=${id }" target="right">作品记录管理</a></li>
	   		
	   <!-- 	<li><a href="#" target="right">学习目标管理</a></li> -->	
	   	</ul>
   	</div>
   	<!-- 这里负责功能页面展示 -->
   	<div id="content">
   	
   	</div>
  </body>
</html>
