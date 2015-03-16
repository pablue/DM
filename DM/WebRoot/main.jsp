<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/Login_head.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.teacher==null">
	<jsp:forward page="/common/ToLogin.jsp" />
</s:if>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>dianming</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="选择，点名">
<meta http-equiv="description" content="教师选择要进行点名的操作">
<meta content="aldfjklsdj">
<link href="<%=basepath%>/images/favicon.ico" rel="SHORTCUT ICON">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" charset="utf-8" src="<%=basepath%>/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/choose.js"></script>

<style type="text/css">
	#kecheng{
	color: red;
	}
	#start{
	color: red;
		
	}
</style>
</head>

<body>
<input id="basepath" value="<%=basepath %>" style="display: none;"></input>
	<s:property value="#session.teacher.tname" />
	老师
	<br />
	<s:hidden value="#session.teacher.tid"></s:hidden>
	<button type="button" id="start">我要开始点名</button>

	<div class="choosecourse" style="display:none">
		请选择要上的课程<br />

		<div id="content"
			style="width:500px;border:1px;border-style: solid;background-color: lightblue;">
		</div>
	</div>


	<div class="loadpage"></div>
	<select id="test" onchange="show()">
		<option>tes1</option>
		<option>tes2</option>
		<option>tes3</option>
		<option>tes4</option>	
	</select>

</body>

</html>
