<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<s:if test="#session.user==null">
	<jsp:forward page="/login.jsp"></jsp:forward>
</s:if>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="">
<title>主页面</title>
<jsp:include page="/jsps/style.jsp"></jsp:include>
</head>

<body>
	<!-- 导航条内容 -->
	<jsp:include page="/jsps/nav.jsp"></jsp:include>
	<div class="container">
	<div class="row">
		<div class="col-xm-12 col-sm-12 col-md-9 col-lg-9" >
		 <s:action  name="diary!listall" executeResult="true"></s:action>
		</div>
		<div class="col-md-3 col-lg-3 hidden-xs hidden-sm"  style="background-color: green;">asdf</div>
	</div>
	</div>
</body>
</html>
