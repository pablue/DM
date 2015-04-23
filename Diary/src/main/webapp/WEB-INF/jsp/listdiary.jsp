<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML>
<html>
<head>

<title>列出我的日记</title>

</head>

<body>

	<div class='datalist'>
		<div class="add_title">
			<span class="glyphicon glyphicon-th-list"></span> 日记列表
		</div>

		<ul class="list-group">
			<s:iterator value="#diarylist">
				<s:iterator value="list" var="diary">
<!-- 				<s:if test="#diary.filepath==null||#diary.filepath==''"> -->
<!-- 				diary!show.action?DiaryId=%{#diary.diaryId} -->
<!-- 				</s:if> -->
					<li class="list-group-item">『 <s:property value="#diary.releaseDate" /> 』<a href="<s:if test='#diary.filepath==null'>
				diary!show.action?DiaryId=${diary.diaryId}
				</s:if>${diary.filepath}">
							<s:property value="#diary.title" />
						</a>
						<button type="button"  class="btn btn-danger btn-sm pull-right">删除</button> <button type="button" class="btn btn-info btn-sm pull-right">修改</button>
				</s:iterator>

			</s:iterator>
		</ul>
		<nav>
			<ul class="pagination">
				<li>总记录数 <s:property value="#diarylist.total" /></li>
				<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>

				<s:iterator begin="1" end="#diarylist.totalpage" var="c">
					<li><a href="diary!listall.action?page=${c} ">${c}</a>
						
					</li>
				</s:iterator>

				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>

	</div>
</body>
</html>
