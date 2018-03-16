<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>My JSP 'addclazzrecord.jsp' starting page</title>

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
		<script type="text/javascript">
function checkAdd() {
	if ($('#userForm').form('validate')) {
		$('#userForm').submit();
	}
}
</script>
	</head>

	<body>
	<h1>${student.name }同学的信息:</h1>
		<form action="manager/student/addClazzRecord.action" method="post" />
			<input type="hidden" name="s_id" value="${s_id }" />
			<table>
				<tr>
					<td>
						课程名<font color="red">(*)</font>:
					</td>
					<td>
						<select name="c_id">
							<option value="0" selected="selected">
								请选择
							</option>
							<c:forEach items="${clazzes}" var="clazz">
								<option value="${clazz.id }">
									${clazz.name }
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						请务必选择
					</td>
				</tr>
				<tr>
					<td>
						课时数<font color="red">(*)</font>:
					</td>
					<td>
						<input type="text" name="classhours" />
					</td>
					<td>
						请填写数字
					</td>
				</tr>
				<tr>
					<td>
						报名时间<font color="red">(*)</font>:
					</td>
					<td>
						<input id="dd" name="signupdate"
							class="easyui-datebox" ></input>
					</td>
					<td>
						请选择日期
					</td>
				</tr>
			</table>
			<input type="submit" value="提交" onclick="checkAdd()"  />
		</form>
		&nbsp;
	</body>
</html>
