<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>列出我的日记</title>

  </head>
  
  <body>
  
  <s:iterator value="#diarylist" var="diary">
  	『<s:property value="#diary.releaseDate"/>』<s:a><s:property value="#diary.title"/></s:a>
  </s:iterator>
  <s:debug></s:debug>
  </body>
</html>
