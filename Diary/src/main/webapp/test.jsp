<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div class='datalist'>
		<div class="add_title">
			<span class="glyphicon glyphicon-th-list"></span> 日记列表
		</div>

		<ul class="list-group">
			<#list diary as d>
			<li class="list-group-item">『 ${d.releaseDate}』<a href="diary!show.action?DiaryId=${d.diaryId}">${d.title}</a>
			</li> </#list>
		</ul>
	</div>
</body>
</html>