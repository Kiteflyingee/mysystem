<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listclassrecord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
td{
text-align: center;
}
</style>
<script type="text/javascript">
function confirmY(){
var flag=confirm("确认做上课记录？这将导致学生剩余课次减少！");
return flag;
}
function confirmX(){
var flag=confirm("确认删除？这将导致学生上课记录丢失！操作不可恢复");
return flag;
}
</script>
  </head>
  
  <body>
  	<h1>${student.name }同学的信息:</h1>
  
  	<a href="manager/student/showAddClazzRecord.action?s_id=${s_id}">添加课次</a>
    <c:if test="${not empty clazzRecords}">
    <table border="1" width="600">
		    <tr>
		    	<td>课程名</td>
		    	<td>报名总课时</td>
		    	<td>剩余课时数</td>
		    	<td>报名时间</td>
		    	<td colspan="3">操作</td>
		    </tr>
		   <c:forEach items="${clazzRecords}" var="clazzrecord">
		   	<tr>
		   		<td>${clazzrecord.clazzinfo.name }</td>
		   		<td>${clazzrecord.classhours }</td>
		   		<td>${clazzrecord.lasthours }</td>
		   		<td><fmt:formatDate value="${clazzrecord.signupdate}" pattern="yyyy年MM月dd日"/></td>
		   		<td colspan="2">
		   		<a href="manager/student/recordClazz.action?id=${clazzrecord.id}" onclick="javascript:return confirmY()">上课记录</a>
		   		 &nbsp;<a href="manager/student/removeClazzRecord.action?id=${clazzrecord.id}" onclick="javascript:return confirmX()">删除</a>
		   		 &nbsp;<a href="manager/student/showEditClazzRecord.action?id=${clazzrecord.id}&s_name=${student.name}">修改</a>
		   		</td>
		   	</tr>
		   </c:forEach>
    </table>
		   </c:if>
		   <c:if test="${empty clazzRecords}">没有添加课次</c:if>
  </body>
</html>
