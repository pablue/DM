<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
	<div class='datalist'>
		<div class="add_title">
			<span class="glyphicon glyphicon-th-list"></span> 日记列表
		</div>

		<ul class="list-group">
			<#list diary as d>
			<li class="list-group-item">『<#if d.releaseDate??> ${d.releaseDate}</#if>』<a href="diary!show.action?DiaryId=${d.diaryId}">${d.title}</a>
				<button type="button"  class="btn btn-danger btn-sm pull-right">删除</button> <button type="button" class="btn btn-info btn-sm pull-right">修改</button>
			</li> 
			
			</#list>
		</ul>
	</div>
</body>
</html>