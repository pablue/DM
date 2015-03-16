<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../common/Login_head.jsp"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登陆</title>


<meta http-equiv="pragma" content="no-cache"><meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"><meta http-equiv="description" content="This is my page">
<link href="<%=basepath%>/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>/css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>/css/bootstrap-social.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>/css/templatemo_style.css" rel="stylesheet"
	type="text/css">
<link href="<%=basepath%>/images/favicon.ico" rel="SHORTCUT ICON">
</head>



<body class="templatemo-bg-image-1">
	<div class="container">
		<div class="col-md-12">
			<s:form cssClass="form-horizontal templatemo-login-form-2"
				role="form" action="login_login.action" method="post">
				<div class="row">
					<div class="col-md-12">
						<h1>WelCome Login</h1>
					</div>
				</div>
				<div class="row">
					<div class="templatemo-one-signin col-md-6">
						<div class="form-group">
							<div class="col-md-12">
								<label for="username" class="control-label">Username</label>
								<div class="templatemo-input-icon-container">
									<i class="fa fa-user"></i> <input type="text"
										class="form-control" id="username" 
										name="username">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="password" class="control-label">Password</label>
								<div class="templatemo-input-icon-container">
									<i class="fa fa-lock"></i> <input type="password"
										class="form-control" id="password" 
										name="password">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="yangzheng" class="control-label">yangzheng</label>
								<s:textfield name="rand" cssClass="form-control yanzheng" />
								<img src="<%=basepath%>/common/rand.jsp" height="16" border="1"
									class="yangzheng_image" id="yangzheng" />
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-12">
								<input type="submit" value="LOG IN" class="btn btn-warning">
							</div>
						</div>

					</div>
					<div class="templatemo-other-signin col-md-6">
						<label class="margin-bottom-15"> One-click sign in using
							other services. Credit goes to <a rel="nofollow"
							href="http://lipis.github.io/bootstrap-social/">Bootstrap
								Social</a> for social sign in buttons.
						</label> <a class="btn btn-block btn-social btn-facebook margin-bottom-15">
							<i class="fa fa-facebook"></i> Sign in with Facebook
						</a> <a class="btn btn-block btn-social btn-twitter margin-bottom-15">
							<i class="fa fa-twitter"></i> Sign in with Twitter
						</a> <a class="btn btn-block btn-social btn-google-plus"> <i
							class="fa fa-google-plus"></i> Sign in with Google
						</a>
					</div>
				</div>
			</s:form>
		</div>
	</div>
</body>
</html>

