<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/ueditor/ueditor.all.min.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/ueditor/lang/zh-cn/zh-cn.js"></script>

</head>

<body>
	<!-- 导航条内容 -->
	<jsp:include page="/jsps/nav.jsp"></jsp:include>
	<div class="container">

		<div class="datalist">
			<div class="add_title">
				<img src="${pageContext.request.contextPath }/bootstrap/image/diary_add_icon.png">写日记
			</div>
			<s:form action="diary!%{tdiaryId==null ?'add':'update'}.action">
				<div class="add_diary_title">
					<input type="text" class="form-control" name="title" placeholder="在这里输入标题">
				</div>

				<div id="editor" type="text/plain" style="height:400px" name="content"></div>
	
	在这里选择类别:<s:select list="#types" headerKey="0" headerValue="select typediary" listKey="id" listValue="typeName" name="tid"></s:select>

				<br>

				<button type="button" class="btn btn-primary" onclick="getPlainTxt()">保存日记</button>
			</s:form>
		</div>
	</div>

	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	
		
	</script>