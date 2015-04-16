<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listtype.jsp' starting page</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<style>
	body{
	margin-top:80px;
	}
</style>

  </head>
  
  <body>
   		
   			<!-- 导航条内容 -->
	<jsp:include page="/jsps/nav.jsp"></jsp:include>
	<div class="container">

		<div class="datalist">
			<div class="add_title">
				日记分类
			</div>
			
			<div>
				<table class="table table-striped table-hover table-condensed">
					<tr>
						<td>类型名称</td>
						<td>操作</td>
					
					</tr>
					<s:iterator value="#typelist" var="type">
					<tr>
						<td><s:property value="#type.typeName"/></td>
						<td><button class="btn btn-primary">修改</button></td>
					
					</tr>
					</s:iterator>
				</table>
				
			</div>
	</div>
	</div>
  </body>
</html>
