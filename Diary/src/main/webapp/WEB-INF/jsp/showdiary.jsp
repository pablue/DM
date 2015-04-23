<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title><s:property value="#diary.title" /></title>
<jsp:include page="/jsps/style.jsp"></jsp:include>

</head>

<body>
<div class="container">
	<jsp:include page="/jsps/nav.jsp"></jsp:include>

	<div class="page-header">
		<h1 ><s:property value="#diary.title" /></h1>
	</div>
	
	<div class="panel panel-default">
		<div class="panel-body">
			<s:property value="#diary.content" escape="false" />
		</div>
	</div>

</div>

</body>
</html>
