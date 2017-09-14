<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div>
			<label for="name">姓名:</label> <input id="name"
				class="easyui-validatebox" type="text" name="name"
				data-options="required:true,missingMessage:'请填写姓名'" />
		</div>
		<div>
			<label>性别:</label> <label for="男">男</label> <input id="男"
				class="easyui-validatebox" type="radio" name="sex" value="男"
				checked="checked" /> <label for="女">女</label> <input id="女"
				class="easyui-validatebox" type="radio" name="sex" value="女" />
		</div>
		<div>
			<label for="age">年龄:</label> <input id="age" class="easyui-numberbox"
				type="text" name="age" data-options="min:1,max:120" />
		</div>
		<div>
			<label for="brithday">生日:</label> <input id="brithday" type="text"
				class="easyui-datebox" name="brithday" required="required"
				data-options="missingMessage:'请填写生日'"></input>
		</div>
		<div>
			<label for="school">学校:</label> <input id="school"
				class="easyui-validatebox" type="text" name="school" />
		</div>
		<div>
			<label for="classroom">班级:</label> <input id="classroom"
				class="easyui-validatebox" type="text" name="classroom" />
		</div>
		<div>
			<a id="btn_submit" class="easyui-linkbutton">提交</a> <a id="btn_reset"
				class="easyui-linkbutton">重填</a>
		</div>
	</form>
	<script>
		$(function() {
			//首先取消表单验证
			$("#ff").form("disableValidation");
		});
		$("#btn_submit").on(
				"click",
				function() {
					//当点击提交按钮时候启用表单验证，并验证表单内容
					var $form = $("#ff");
					$form.form("enableValidation");
					//如果表单内容校验通过则提交，否则提示
					if ($form.form("validate")) {
						$form.form({
							url : "${mypath}/main/addstudent.action",
							success : function(data) {
								//提交成功做些动作
								//关闭窗口(注意iframe的父窗体)，并刷新datagrid
								parent.$('#win').window('close'); // close a window
								var win = parent.$("iframe[title='学生信息管理']")
										.get(0).contentWindow;//返回ifram页面文档（window)
								win.$('#dg').datagrid("reload");
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