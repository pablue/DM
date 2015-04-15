<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<div id="login_reg_dialog">
	<div class="dialog">
		<form method="post" class="form form-block">
			<div class="dialog-head">
				<span class="close rotate-hover"></span> <strong>注册</strong>
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
						<input type="password" class="input" id="password" name="password" placeholder="请输入密码" />
					</div>
				</div>
			</div>
			<div class="dialog-foot">
				<button class="button dialog-close">取消</button>
				<button class="button bg-green" id="submit" type="button">确认</button>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript">
	$("input").keypress(function(e) {
		// 回车键事件 
		if (e.which == 13) {
			$("#submit").click();
		}
	});
	$("#submit")
			.click(
					function() {

						$
								.ajax({
									url : "${pageContext.request.contextPath }/userAction!reg.action",
									data : $('form').serialize(),
									type : 'POST',
									success : function(data) {
										console.log(data);
										var obj = jQuery.parseJSON(data);
										console.log(obj);
										if (obj.success) {
											$(".dialog").removeClass("open");
											var alertmsg = $('<div class="alert alert-green"><span class="close rotate-hover"></span><strong>恭喜：</strong>'
													+ obj.msg + '</div>');
											$(".container").append(alertmsg);
										}
									}
								});
					});
//-->
</script>
