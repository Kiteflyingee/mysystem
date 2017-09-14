<%@ page language="java"  import="java.net.URLEncoder" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

		<title>My JSP 'listworks.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
.work {
	border: 1px solid;
	width: 350px;
	height: 185px;
	float: left;
}

#title {
	position: absolute;
	left: 400px;
	top: 30;
	font-size: 26px;
	color: blue;
}
</style>
<script type="text/javascript">
function confirmDelete(){
var flag=confirm("确认删除？这将导致作品丢失！操作不可恢复");
return flag;
}
</script>
	</head>

	<body>
		<a href="manager/student/showAddWork.action?s_id=${s_id }">添加作品</a>
		<c:if test="${empty page.results}">
			尚未添加数据
		</c:if>
		<c:if test="${not empty page.results}">
		
			<br />
			<div style="width: 1230px; padding: 10px; overflow: hidden">
				<c:forEach var="work" items="${page.results}" varStatus="status">
					<div class="work">
						<div style="float: left">
							<img style="width: 150; height: 150"
								src="${pageContext.request.contextPath }/image/${student.id}/${work.filename }">
						</div>
						<div style="float: left">
							<ul>
								<li>
								<div style="width: 130px">
									${work.name }
								</div>
								</li>
								<li>
								<div style="width: 130px">
									${work.w_comment }
								</div>
								</li>
								<li>
									<fmt:formatDate value="${work.pubtime }" pattern="yyyy年MM月dd日"/>
								</li>
								<li>
									<a
										href="${pageContext.request.contextPath }/image/${student.id}/${work.filename }">查看大图</a>
								</li>
								<li>
									<a
										href="${pageContext.request.contextPath}/manager/student/removeWork.action?id=${work.id}" onclick="javascript:return confirmDelete()" >删除</a>
								</li>
							</ul>
						</div>
						<c:if test="${status.count%3==0}">
						</c:if>
						<br />
					</div>
				</c:forEach>
			</div>
				<div id="listpagenum">
				<div style="clear: both"></div>
				当前第[${page.currentPage }]页&nbsp;&nbsp;
				<a
					href="${pageContext.request.contextPath }/manager/student/listWorks.action?currentPage=${page.previousPage }&s_id=${s_id}">上一页</a>
				<c:forEach var="pageNum" items="${page.pageBar}">
					<a
						href="${pageContext.request.contextPath }/manager/student/listWorks.action?currentPage=${pageNum }&s_id=${s_id}">${pageNum}</a>
				</c:forEach>
				<a
					href="${pageContext.request.contextPath }/manager/student/listWorks.action?currentPage=${page.nextPage }&s_id=${s_id}">下一页</a>
				&nbsp;&nbsp;共[${page.totalPage }]页,共[${page.totalNum }]条记录
			</div>
		</c:if>
	</body>
</html>
