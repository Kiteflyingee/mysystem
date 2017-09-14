<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'welcome.jsp' starting page</title>
<frameset cols="20%,*" frameborder="yes">
	<frame name="left" frameborder="1" src="<%=basePath %>manager/student/left.action?id=${id}"></frame>
	<frame name="right" frameborder="1" src="<%=basePath %>manager/student/right.action"></frame>
</frameset>
</html>
