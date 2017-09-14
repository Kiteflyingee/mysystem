<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listparents.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
function confirmDelete(){
var flag=confirm("确认删除？这将导致信息丢失！操作不可恢复");
return flag;
}
</script>
  <body>
  
  <c:if test="${empty parents}">
  	尚未添加信息
  </c:if>
  <br/>
  <a href="manager/student/showAddParent.action?id=${s_id }">添加家长信息</a>
  <c:if test="${not empty parents}">
  	<div>
  		<table border="1" width="600">
  			<tr>
  				<td>姓名</td>
  				<td>关系</td>
  				<td>手机</td>
  				<td>住址</td>
  				<td>工作</td>
  				<td>公司</td>
  				<td>操作</td>
  			</tr>
  			<c:forEach items="${parents}" var="parent">
  			<tr>
  				<td>${parent.name }</td>  
				<td>${parent.relation }</td>  				
				<td>${parent.mobile }</td>  				
				<td>${parent.address }</td>  				
				<td>${parent.job }</td>  				
				<td>${parent.company }</td>  				
				<td><a href="manager/student/removeParent.action?id=${parent.id }" onclick="javascript:return confirmDelete()">删除</a></td>  				
  			</tr>
  			</c:forEach>
  		</table>
  		</div><br/>
  	
  	</c:if>
  </body>
</html>
