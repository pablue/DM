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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>主页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/mycss.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/bootstrap/myjs.js"></script>
</head>

<body>
	<!-- 导航条内容 -->
	<jsp:include page="/jsps/nav.jsp"></jsp:include>
	<div class="container">
	<div class="row">
		<div class="col-xm-12 col-sm-12 col-md-9 col-lg-9" >
		 <s:action  name="userAction!addtypeui" executeResult="true" namespace="/"></s:action>
		</div>
		<div class="col-md-3 col-lg-3 hidden-xs hidden-sm"  style="background-color: green;">asdf</div>
	</div>
	</div>
</body>
</html>
