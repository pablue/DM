<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>跳转到登陆页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<link href="<%=basepath%>/images/favicon.ico" rel="SHORTCUT ICON">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	对不起，您的登录已经过期!
	<br> 请重新登录,谢谢! 页面将在

	<br />
	<span id="num">5</span>内跳到登陆页面
	<br />
	<a href="<%=basepath%>/login.jsp">如果没有跳转，点击这里</a>
</body>

<script language="javascript">
	var t = 4;
	var flush = null;
	function flushTime() {
		if (t == -1 || t < -1) {
			window.top.location = "login.jsp";
			
		} else {
			document.getElementById("num").innerHTML = t;
		}
		t = t - 1;
	}
	flush = setInterval("flushTime()", 1000);
</script>
<script type="text/javascript">
	//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
	function banBackSpace(e) {
		var ev = e || window.event;//获取event对象   
		var obj = ev.target || ev.srcElement;//获取事件源   

		var t = obj.type || obj.getAttribute('type');//获取事件源类型  

		//获取作为判断条件的事件类型
		var vReadOnly = obj.getAttribute('readonly');
		var vEnabled = obj.getAttribute('enabled');
		//处理null值情况
		vReadOnly = (vReadOnly == null) ? false : vReadOnly;
		vEnabled = (vEnabled == null) ? true : vEnabled;

		//当敲Backspace键时，事件源类型为密码或单行、多行文本的，
		//并且readonly属性为true或enabled属性为false的，则退格键失效
		var flag1 = (ev.keyCode == 8
				&& (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vEnabled != true)) ? true
				: false;

		//当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
		var flag2 = (ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea") ? true
				: false;

		//判断
		if (flag2) {
			return false;
		}
		if (flag1) {
			return false;
		}
	}

	//禁止后退键 作用于Firefox、Opera
	document.onkeypress = banBackSpace;
	//禁止后退键  作用于IE、Chrome
	document.onkeydown = banBackSpace;
</script>
</html>
