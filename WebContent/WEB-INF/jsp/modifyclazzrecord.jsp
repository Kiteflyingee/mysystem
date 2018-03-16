<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
		<h1>${s_name }同学的信息:</h1>
	
	<div><font color="red">在非必要的情况下请勿修改</font></div>
		<form action="manager/student/editClazzRecord.action" method="post" />
			<input type="hidden" name="s_id" value="${clazzrecord.student.id }" />
			<input type="hidden" name="id" value="${clazzrecord.id }" />
			<table>
				<tr>
					<td>
						课程名<font color="red">(*)</font>:
					</td>
					<td>
						<select name="c_id">
							<c:forEach items="${clazzes}" var="clazz">
								<!-- 把修改前的课程名记录并显示处理 -->
								<c:if test="${clazz.id==clazzrecord.clazzinfo.id}">
									<option value="${clazz.id }" selected="selected">
									${clazz.name }
									</option>
								</c:if>
								<c:if test="${clazz.id!=clazzrecord.clazzinfo.id}">
								<option value="${clazz.id }">
									${clazz.name }
								</option>
								</c:if>
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
						<input type="text" name="classhours" value="${clazzrecord.classhours }"/>
					</td>
					<td>
						请填写数字
					</td>
				</tr>
				<tr>
					<td>
						剩余课时数<font color="red">(*)</font>:
					</td>
					<td>
						<input type="text" name="lasthours" value="${clazzrecord.lasthours }"/>
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
							class="easyui-datebox" value='<fmt:formatDate pattern="MM/dd/yyyy" value="${clazzrecord.signupdate }"/>'></input>
							<font color="red">日期格式:MM/dd/yyyy，可以手动填写</font>
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
