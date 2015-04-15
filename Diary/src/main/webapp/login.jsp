<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<s:if test="#session.user!=null">
	<jsp:forward page="main.jsp"></jsp:forward>
</s:if>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
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
<title>title</title>
</head>

<body>
	<div class="container">

		<div class="login_form">
			<form class="form-horizontal" action="${pageContext.request.contextPath }/userAction!login.action" method="post" onsubmit="return login_formcheck()">
				<div class="form-group">
					<label for="username" class="sr-only">Email address</label>
					<div class="input-group">
						<div class="input-group-addon">
							<i class=" glyphicon glyphicon-user"></i>
						</div>
						<input type="text" class="form-control" id="login_username" name="userName" placeholder="Enter username" autocomplete="off">
					</div>
				</div>
				<div class="form-group">

					<label for="password" class="sr-only">Password</label>

					<div class="input-group">
						<div class="input-group-addon">
							<i class="glyphicon glyphicon-pencil"></i>
						</div>
						<input type="password" class="form-control" id="login_password" name="password" placeholder="Password">
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
				<span><s:actionerror /></span>
			</form>
		</div>

	</div>

</body>
</html>
