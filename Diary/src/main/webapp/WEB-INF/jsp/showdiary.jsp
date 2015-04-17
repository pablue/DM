<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>show tables</title>
    <jsp:include page="/jsps/style.jsp"></jsp:include>

</head>

<body>
  <jsp:include page="/jsps/nav.jsp"></jsp:include>
	标题
	<s:property value="#diary.title" />
	<br> 内容:
	<s:property value="#diary.content" escape="false"/>

</body>
</html>
