<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String basepath = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basepath%>">
    
    <title>404 - Not found</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="keywords" content="错误页面">
	<meta http-equiv="description" content="404">
	<link rel="stylesheet" href="<%=basepath%>/css/main.css" type="text/css" media="screen, projection" /> <!-- main stylesheet -->
	<link rel="stylesheet" type="text/css" media="all" href="<%=basepath%>/css/tipsy.css" /> 

<script type="text/javascript" src="<%=basepath%>/js/jquery-1.11.1.js"></script> <!-- uiToTop implementation -->
<script type="text/javascript" src="<%=basepath%>/js/custom-scripts.js"></script>
<script type="text/javascript" src="<%=basepath%>/js/jquery.tipsy.js"></script> <!-- Tipsy -->

<script type="text/javascript">

$(document).ready(function(){
			
	universalPreloader();
						   
});

$(window).load(function(){

	//remove Universal Preloader
	universalPreloaderRemove();
	
	rotate();
    dogRun();
	dogTalk();
	
	//Tipsy implementation
	$('.with-tooltip').tipsy({gravity: $.fn.tipsy.autoNS});
						   
});

</script>

  </head>
  
  <body>
   <div id="universal-preloader">
    <div class="preloader">
        <img src="<%=basepath %>/images/universal-preloader.gif" alt="universal-preloader" class="universal-preloader-preloader" />
    </div>
</div>
<!-- Universal preloader -->

<div id="wrapper">
<!-- 404 graphic -->
	<div class="graphic"></div>
<!-- 404 graphic -->
<!-- Not found text -->
	<div class="not-found-text">
    	<h1 class="not-found-text">File not found, sorry!</h1>
    </div>
<!-- Not found text -->

<!-- search form -->

<!-- search form -->

<!-- top menu -->
<!-- top menu -->

<div class="dog-wrapper">
<!-- dog running -->
	<div class="dog"></div>
<!-- dog running -->
	
<!-- dog bubble talking -->
	<div class="dog-bubble">
    	
    </div>
    
    <!-- The dog bubble rotates these -->
    <div class="bubble-options">
    	<p class="dog-bubble">
        	Are you lost, bud? No worries, I'm an excellent guide!
        </p>
    	<p class="dog-bubble">
	        <br />
        	Arf! Arf!
        </p>
        <p class="dog-bubble">
        	<br />
        	Don't worry! I'm on it!
        </p>
        <p class="dog-bubble">
        	I wish I had a cookie<br /><img style="margin-top:8px" src="images/cookie.png" alt="cookie" />
        </p>
        <p class="dog-bubble">
        	<br />
        	Geez! This is pretty tiresome!
        </p>
        <p class="dog-bubble">
        	<br />
        	Am I getting close?
        </p>
        <p class="dog-bubble">
        	Or am I just going in circles? Nah...
        </p>
        <p class="dog-bubble">
        	<br />
            OK, I'm officially lost now...
        </p>
        <p class="dog-bubble">
        	I think I saw a <br /><img style="margin-top:8px" src="images/cat.png" alt="cat" />
        </p>
        <p class="dog-bubble">
        	What are we supposed to be looking for, anyway? @_@
        </p>
    </div>
    <!-- The dog bubble rotates these -->
<!-- dog bubble talking -->
</div>

<!-- planet at the bottom -->
	<div class="planet"></div>
<!-- planet at the bottom -->
</div>
  </body>
</html>
