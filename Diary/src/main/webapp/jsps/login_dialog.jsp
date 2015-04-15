<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<title>Login</title>
<!--     为了让 IE 浏览器运行最新的渲染模式下 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 让浏览器运行高速模式 -->
<meta name="renderer" content="webkit">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="pintuer/pintuer.css">
<script src="pintuer/jquery-1.11.1.js"></script>
<script src="pintuer/pintuer.js"></script>
<!-- 暂时不引入 -->
<!-- <script src="http://pintuer.com/pintuer.js"></script> -->


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<div class="dialog">
		<form method="post" class="form form-block">
			<div class="dialog-head">
				<span class="close rotate-hover"></span> <strong>登陆</strong>
			</div>
			<div class="dialog-body">
				<div class="form-group">
					<div class="label">
						<label for="username">账号</label>
					</div>
					<div class="field">
						<input type="text" class="input" id="username" name="userName" size="50" data-validate="required:必填" placeholder="手机/邮箱/账号" />
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label for="password">密码</label>
					</div>
					<div class="field">
						<input type="password" class="input" id="password" name="password" size="50" data-validate="required:必填" placeholder="请输入密码" />
					</div>
				</div>

			</div>
			<div class="dialog-foot">
				<button class="button dialog-close">取消</button>
				<button class="button bg-green" id="logindialog_login" type="button">确认</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		$("input").keypress(function(e) {
			// 回车键事件 
			if (e.which == 13) {
				$("#logindialog_login").click();
			}
		});
		$("#logindialog_login")
				.click(
						function() {
							alert("dsfasdf");
							$.ajax({
										url : "${pageContext.request.contextPath }/userAction!login.action",
										data : $('form').serialize(),
										success : function(datajson) {
											console.log(datajson);
											var obj = jQuery.parseJSON(datajson);
											console.log(obj);
											if (obj.success) {
												$(".dialog")
														.removeClass("open");
												var alertmsg = $('<div class="alert alert-green"><span class="close rotate-hover"></span><strong>恭喜：</strong>'
														+ obj.msg + '</div>');
												$(".container")
														.append(alertmsg);
											}
										}

									});

						});
	//-->
	</script>
</body>
</html>