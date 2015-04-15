<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span class="glyphicon glyphicon-cloud"></span>我的日记本 </a>
		</div>
		<div class="collapse navbar-collapse " id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="userAction!mainUI.action"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
				<li><a href="userAction!addtypeui.action"><span class="glyphicon glyphicon-pencil"></span> 写日记</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-book"></span> 日记分类管理</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> 个人中心</a></li>
			</ul>
		</div>
	</div>
</nav>
