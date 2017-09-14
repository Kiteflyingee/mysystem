<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>My JSP 'liststudent.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
td {
	text-align: center;
	margin: auto;
}

#listpagenum {
	margin-top: 5px;
}
</style>
</head>
 <script type="text/javascript">
function confirmDelete(){
var flag=confirm("确认删除？这将导致有关该学生的所有信息（包括作品和家长等信息）丢失！操作不可恢复");
return flag;
}
</script>
<body>
	<table cellspacing="1" border="1">
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>生日</td>
			<td>年龄</td>
			<td>学校</td>
			<td>班级</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.results}" var="student">
			<tr>
				<td><a href="${myurl }?id=${student.id}" target="_Blank">${student.name }</a></td>
				<td>${student.sex }</td>
				<td><fmt:formatDate pattern="yyyy年MM月"
						value="${student.brithday }" /></td>
				<td>${student.age }</td>
				<td>${student.school }</td>
				<td>${student.classroom }</td>
				<td><a href="manager/main/deleteStudent.action?id=${student.id} " onclick="javascript:return confirmDelete()">删除</a></td>
			</tr>
		</c:forEach>
	</table>

	<!-- v1.0版本用基础html编写，未考虑到<a>暴露访问路径的问题，解决思路：1.在每个方法都判断一下用户登录（其实是必要的）2.使用ajax提交 form的形式分页-->
	<div id="listpagenum">
		<div style="clear: both"></div>
		当前第[${pageBean.currentPage }]页&nbsp;&nbsp; <a
			href="${url }?currentPage=${pageBean.previousPage }">上一页</a>
		<c:forEach var="pageNum" items="${pageBean.pageBar}">
			<a href="${url }?currentPage=${pageNum }">${pageNum}</a>
		</c:forEach>
		<a href="${url }?currentPage=${pageBean.nextPage }">下一页</a>
		&nbsp;&nbsp;共[${pageBean.totalPage }]页,共[${pageBean.totalNum }]条记录
</body>
</html>
