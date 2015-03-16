<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	//取得当前Web应用的名称
	String basepath = request.getContextPath();
	session.setAttribute("basepath", basepath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basepath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="asdlfj">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basepath%>/js/jquery-1.11.1.js"></script>
</head>

<body>
	This is my JSP page.
	<br>
	<a href="<%=basepath%>">asdfl</a>

	<!--请先在网页中插入激活弹窗的按钮，如下示例：-->
	<div class="popButton">
		<!--请将"popButton"改为自己的类名-->
		demo
		<div>提示</div>
		<div>这是一个Demo</div>
	</div>
	<!--以上代码修改完以后可直接复制并粘贴到你的网页上！-->
	
	<a href="course_getcoursebytid.action">根据教师ID</a>
	
	
	对不起，你不有登陆

	<script type="text/javascript">
			
		
			$(".popButton").click(function(){
				showWindow('password','login.jsp');
			});
	
		function initPopJs(){
	//在此处添加弹窗内容中要执行的Js脚本与消息绑定
		}
				//-->
				</script>

</body>
</html>
