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
<jsp:include page="/jsps/style.jsp"></jsp:include>
</head>

<body>
	<!-- 导航条内容 -->
	<jsp:include page="/jsps/nav.jsp"></jsp:include>
	<div class="container">
		<div class="col-xm-12 col-sm-12 col-md-9 col-lg-9">
			<div class="datalist">
				<div class="add_title">
					<img src="${pageContext.request.contextPath }/bootstrap/image/diary_add_icon.png">写日记
				</div>
				<s:form action="diary!%{tdiaryId==null ?'add':'update'}.action">
					<div class="add_diary_title">
						<input type="text" class="form-control" name="title" placeholder="在这里输入标题">
					</div>
					<div class="form-group">
						<label>在这里选择类别:</label>
						<s:select list="#types" headerKey="0" headerValue="-----select-----" listKey="id" listValue="typeName" name="tid" cssClass="form-control"></s:select>
					</div>

					<div id="editor" type="text/plain" style="height:400px;width: 800px;" name="content"></div>

					<button class="btn btn-primary">保存日记</button>
				</s:form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>