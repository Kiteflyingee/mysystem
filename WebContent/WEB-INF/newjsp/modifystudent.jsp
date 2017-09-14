<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>Title</title>
<%@include file="/common/easyuicommon.jspf"%>
<style>
a {
	margin: 20px;
}
</style>
</head>
<body>
	<form id="ff" method="post">
	<input type="hidden" name="id" value="${requestScope.student.id }">
		<div>
			<label for="name">姓名:</label> <input id="name"
				class="easyui-validatebox" type="text" name="name" value="${requestScope.student.name}"
				data-options="required:true,missingMessage:'请填写姓名'" />
		</div>
		<div>
			<label>性别:</label> <label for="男">男</label> <input id="男"
				class="easyui-validatebox" type="radio" name="sex" value="男"
				<c:if test='${"男"==requestScope.student.sex }'>checked="checked"</c:if> /> <label for="女">女</label> <input
				id="女" class="easyui-validatebox" type="radio" name="sex" value="女"
				<c:if test='${"女"==requestScope.student.sex }'>checked="checked"</c:if>/>
		</div>
		<div>
			<label for="age">年龄:</label> <input id="age" class="easyui-numberbox"
				type="text" name="age" value="${requestScope.student.age}" data-options="min:1,max:120" />
		</div>
		<div>
			<label for="brithday">生日:</label> <input id="brithday" type="text"
				class="easyui-datebox" name="brithday"
				value="<fmt:formatDate value='${requestScope.student.brithday }'/>" required="required"
				data-options="missingMessage:'请填写生日'"></input>
		</div>

		<div>
			<label for="school">学校:</label> <input id="school"
				class="easyui-validatebox" type="text" value="${requestScope.student.school}"
				name="school" />
		</div>
		<div>
			<label for="classroom">班级:</label> <input id="classroom"
				class="easyui-validatebox" type="text" value="${requestScope.student.classroom}"
				name="classroom" />
		</div>
		<div>
			<a id="btn_submit" class="easyui-linkbutton">确认</a> <a id="btn_reset"
				class="easyui-linkbutton">重填</a>
		</div>
	</form>
	<script>
		$("#btn_submit").on(
				"click",
				function() {
					//当点击提交按钮时候启用表单验证，并验证表单内容
					var $form = $("#ff");
					//如果表单内容校验通过则提交，否则提示
					if ($form.form("validate")) {
						$form.form({
							url : "${mypath}/main/midifystudent.action",
							success : function(data) {
								//修改成功做些动作
								//关闭窗口，并刷新datagrid
								parent.$('#win').window('close'); // close a window
								//获取iframe的文档内容(即datagrid等内容),然后就可以选择出datagrid进行刷新
								var win = parent.$("iframe[title='学生信息管理']")
										.get(0).contentWindow;//返回ifram页面文档（window)
								win.$('#dg').datagrid("reload");
								$.messager.alert("修改成功", "提示");
							}
						});
						// submit the form
						$('#ff').submit();
					}
				});
		//为重填按钮添加事件
		$("#btn_reset").on("click", function() {
			$('#ff').form("clear");
		});
	</script>
</body>
</html>