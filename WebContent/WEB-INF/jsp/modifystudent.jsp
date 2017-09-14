<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	</head>
	<script type="text/javascript">
function checkAdd() {
	if ($('#userForm').form('validate')) {
		$('#userForm').submit();
	}
}
</script>
	<body>
		<form action="${pageContext.request.contextPath }/${url }"
			class="easyui-form" method="POST" id="userForm">
			<table border="1">
			<input type="hidden" name="id" value="${student.id}"/>
				<tr>
					<td>
						姓名:
					</td>
					<td>
						<input name="name" class="easyui-validatebox"
							value="${student.name}" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<td>
						性别:
					</td>
					<td>
						<input name="sex" class="easyui-validatebox"
							value="${student.sex}" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<td>
						年龄
					</td>
					<td>
						<input name="age" class="easyui-validatebox"
							value="${student.age}" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<td>
						生日:
					</td>
					<td>
						<input id="dd" name="brithday" class="easyui-datebox"
							value="<fmt:formatDate pattern="MM/dd/yyyy"
						value='${student.brithday }' />" required="required"></input>
					</td>
				</tr>
				<tr>
					<td>
						学校:
					</td>
					<td>
						<input name="school" value="${student.school}" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						班级:
					</td>
					<td>
						<input name="classroom"  value="${student.classroom}" type="text" />
					</td>
				</tr>
			</table>
			<input type="submit" onclick="checkAdd()" value="提交" >
		</form>
	</body>
</html>
