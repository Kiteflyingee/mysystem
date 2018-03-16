<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
<head>
<%@include file="/common/easyuicommon.jspf"%>
<style type="text/css">
body {
	margin: 50px;
	padding: 10px;
	text-align: center;
}

.datagrid-row {
	height: 35px;
}

.datagrid-cell {
	font-size: 15px;
}

.datagrid-header .datagrid-cell span {
	font-size: 20px;
	line-height: 35px;
}

.datagrid-header .datagrid-cell {
	height: 35px;
}

.datagrid-toolbar {
	height: 35px;
}
</style>
<script type="text/javascript" src="${mypath }/js/myjs.js"></script>
<script>
	$(function() {
		$('#dg')
				.datagrid(
						{
							url : '${mypath}/main/liststudents.action',
							singleSelect : true,
							fitColumns : true,
							autoRowHeight : false,
							loadMsg : '载入中',
							pagination : true,
							rownumbers : true,
							pageList : [ 5, 8, 10 ],
							pageSize : 5,
							width : 1000,
							columns : [ [ {
								field : 'id',
								title : '编号',
								checkbox : true,
								width : 100
							}, {
								field : 'name',
								title : '姓名',
								width : 100
							}, {
								field : 'sex',
								title : '性别',
								width : 100
							}, {
								field : 'age',
								title : '年龄',
								width : 100
							}, {
								field : 'brithday',
								title : '生日',
								width : 100,
								formatter : function(value, row, index) {
									return getYearMonth(value);
								}
							}, {
								field : 'school',
								title : '学校',
								width : 100
							}, {
								field : 'classroom',
								title : '班级',
								width : 100
							} ] ],
							"onLoadSuccess" : function() {
								$(".datagrid-header-check").html("");
							},
							toolbar : [
									{
										iconCls : 'icon-add',
										handler : function() {
											parent
													.$('#win')
													.window(
															{
																width : 600,
																height : 400,
																modal : true,
																title : '添加学生信息',
																content : '<iframe title="添加学生" height="100%" width="100%" src="${mypath}/base/goToJsp/newjsp/insertstudent.action"></iframe>'
															});
										}
									},
									'-',
									{
										iconCls : 'icon-edit',
										handler : function() {
											//				处理修改学生信息的前台
											//	              获取用户选中的行;
											var row = $("#dg").datagrid(
													"getSelected");
											if (row == null) {
												parent.$.messager
														.alert("error",
																"您还没有选择要修改的行！");
											} else {
												parent
														.$('#win')
														.window(
																{
																	width : 600,
																	height : 400,
																	modal : true,
																	title : '修改学生信息',
																	content : '<iframe title="修改学生信息" height="100%" width="100%" src="${mypath}/main/showdetail.action?id='+row.id+'"></iframe>'
																});
											}
										}
									},
									'-',
									{
										iconCls : 'icon-remove',
										handler : function() {
											console.log("删除按钮");
											//	              获取用户选中的行;
											var row = $("#dg").datagrid(
													"getSelected");
											if (row == null) {
												parent.$.messager
														.alert("error",
																"您还没有选择要删除的行！");
											} else {
												parent.$.messager
														.confirm(
																'确认',
																'您确认想要删除记录吗？',
																function(r) {
																	if (r) {
																		$
																				.ajax({
																					url : "${mypath}/main/deletestudent.action",
																					type : "POST",
																					data : {
																						id : row.id
																					},
																					success : function() {
																						parent.$.messager
																								.alert(
																										"提示消息",
																										"删除成功");
																						$(
																								"#dg")
																								.datagrid(
																										"reload");
																					},
																					error : function() {
																						parent.$.messager
																								.alert(
																										"error",
																										'删除失败,请联系管理员');
																					}
																				});
																	}
																});
											}
										}
									}, '-', {
										text : '<div id="ss" ></div>'
									} ]
						});
		$('#ss').searchbox({
			searcher : function(value, name) {
				//做查询学生信息的操作
				alert(value + "," + name)
			},
			prompt : '请输入学生姓名',
		});
		changeDatagrid();
		$.parser.parse();
	});
</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>