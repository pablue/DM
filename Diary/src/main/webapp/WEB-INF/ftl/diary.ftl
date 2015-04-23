<!DOCTYPE html>
<html>
<head>
<#---- <#if mouse??> Mouse found <#else> No mouse found </#if> ---->
<title><#if diary.title??>${diary.title}</#if></title>

<meta name="keywords" content="<#if diary.keyword??>${diary.keyword}</#if>" />
<meta name="description" content="<#if diary.keyword??>${diary.keyword}</#if>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="icon" href="/Diary/bootstrap/image/favicon.ico" type="image/ico">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/Diary/bootstrap/mycss.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="/Diary/bootstrap/myjs.js"></script>

</head>

<body>

	<div class="container">
		<!-- S nav -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="userAction!mainUI.action"><span class="glyphicon glyphicon-cloud"></span>我的日记本 </a>
				</div>
				<div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="/Diary/userAction!mainUI.action"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
						<li><a href="/Diary/userAction!addtypeui.action"><span class="glyphicon glyphicon-pencil"></span> 写日记</a></li>
						<li><a href="/Diary/type!list.action"><span class="glyphicon glyphicon-book"></span> 日记分类管理</a></li>
						<li><a href="/Diary/userAction!mainUI.action"><span class="glyphicon glyphicon-user"></span> 个人中心</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- E nav -->
		
		<!-- S content -->
		<div class="row">
			<div class="col-xm-12 col-sm-12 col-md-8 col-lg-8">
				<div class="page-header">
					<h1><#if diary.title??>${diary.title}</#if></h1>
				</div>
				
		
				<!-- S body -->
				<div class="panel panel-default">
					<div class="panel-body"><#if diary.content??>${diary.content}</#if></div>
				</div>
			<!-- S body -->
			</div>
			
			<!-- S right -->
			<div class="col-md-3 col-lg-3 hidden-xs hidden-sm">
				<img src="/Diary/bootstrap/image/534347_103334_6122.jpg" alt="admin" width="250px">
				<p style="text-align: center; margin-top: 20px; font-size: 20px">其实我不是一个屌丝</p>
			</div>
			<!-- E right -->
		</div>
		
		<!-- E content -->
	</div>
</body>
</html>

