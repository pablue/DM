<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%>

<img  src="${user.imageName}" alt="${user.userName }" width="250px">
<p style="text-align: center; margin-top: 20px; font-size: 20px">${user.mood}</p>
