<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>类型分类</title>
<jsp:include page="/jsps/style.jsp"></jsp:include>


<style>
body {
	margin-top: 80px;
}
</style>

</head>

<body>

	<!-- 导航条内容 -->
	<jsp:include page="/jsps/nav.jsp"></jsp:include>
	<div class="container">
		<div class="col-xm-12 col-sm-12 col-md-9 col-lg-9">
			<div class="datalist">
				<div class="add_title">
					<span class="glyphicon glyphicon-th"></span> 日记分类<span class="pull-right "><a class="btn btn-info btn-xs right_button">添加</a></span>
				</div>

				<div>
					<table class="table table-striped table-hover table-condensed">
						<tr>
							<td>类型名称</td>
							<td>操作</td>

						</tr>
						<s:iterator value="#typelist" var="type">
							<tr>
								<td><s:property value="#type.typeName" /></td>
								<td><button class="btn btn-primary">修改</button></td>

							</tr>
						</s:iterator>
					</table>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
