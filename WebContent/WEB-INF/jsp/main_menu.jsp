<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'left.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	padding: 0;
	margin: 0;
}

#menu {
	margin-top: 30%;
	margin-left: 20px;
}

.dc {
	display: none;
	margin-left: 10px;
}
</style>

<script language="javascript">
	function test(e) {
		e.style.display = e.style.display == 'block' ? 'none' : 'block';
	}
</script>
</head>

<body>
	<div id="menu">
		<h4>画室信息管理系统</h4>
	</div>
	<ul>
		<li>
			<div onclick="test(children[1])"><a href="javascript:void(0);" target="left">学生信息管理</a>
				<div class="dc">
		    			<a href="listStudents.action?currentPage=1"  target="right">查看学生</a><br/>
		    			<a href="showAddStudent.action"  target="right">添加学生</a><br/>
		    	</div>
		    </div>	
		</li>
		<li><div onclick="test(children[1])"><a href="javascript:void(0);" target="left">课程信息管理</a>
			<div class="dc">
	    			<a href="showClazz.action"  target="right">查看课程</a><br/>
	    			<a href="showAddClazz.action"  target="right">添加课程</a><br/>
	    	</div>
	    	</div>
		</li>
	</ul>
</body>
</html>
