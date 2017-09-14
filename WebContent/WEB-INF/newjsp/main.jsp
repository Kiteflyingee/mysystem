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
<%@include file="/common/easyuicommon.jspf"%>
<link rel="stylesheet" type="text/css" href="${mypath }/newcss/main.css">
<script>
	$(function() {
		$("li a[title]")
				.on(
						"click",
						function() {
							var text = $(this).text();
							var $href = $(this).attr("href");
							var isExist = $("#tt").tabs('exists', text);
							if (isExist) {
								$("#tt").tabs('select', text);
							} else {
								$("#tt")
										.tabs(
												'add',
												{
													title : text,
													content : "<iframe src='"
															+ $href
															+ "' title='"
															+ text
															+ "' height='100%' width='100%' frameborder='0px'></iframe>",
													closable : true,
												});
								//每打开一个新面板设置新面板不显示滚动条
								$('.panel-body-noborder').css('overflow',
										'hidden');
							}
							return false;
						});
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'艺柒画室管理系统',split:true"
		style="height: 100px;">欢迎您,${sessionScope.admin.username}！（可以做个横版的图片）</div>
	<div data-options="region:'south',title:' ',split:true"
		style="height: 60px;">
		<div style="text-align: center;">@2017 艺柒画室版权所有</div>
	</div>
	<div data-options="region:'west',title:'基础信息操作',split:true"
		style="width: 200px; overflow: hidden">
		<div id="aa" class="easyui-accordion" style="width: 200px;">
			<div title="基础信息录入" style="padding: 10px;">
				<ul>
					<li><a
						href="${mypath }/base/goToJsp/newjsp/liststudents.action"
						title="学生信息管理">学生信息管理</a></li>
					<li><a href="manager/main/showClazz.action" title="课程信息管理">课程信息管理</a></li>
				</ul>
			</div>
			<div title="扩展功能"></div>
		</div>

	</div>
	<div data-options="region:'center',title:'操作页面'"
		style="padding: 5px; background: #eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">
			<div title="欢迎页面" style="padding: 20px;">
				<strong> 这里可以写点艺柒画室的介绍，或者加点图片，欢迎页面也已。 </strong>
			</div>
		</div>
	</div>
	<!-- 用来存放弹出页面 -->
	<div id="win"></div>
</body>
</html>