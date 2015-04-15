<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML >
<html>
<head>
<title>添加日记类型</title>
</head>

<body>

	<s:form action="/type!%{id==null?'add':'update'}.action" method="POST" namespace="/">
		<s:hidden name="id" value="%{id}" />
		<s:textfield name="typeName" />
		<s:submit value="添加"></s:submit>
	</s:form>
</body>
</html>
