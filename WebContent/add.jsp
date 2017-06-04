<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- struts2标签库调用声明 -->
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
</head>
<body>
<center>
	<s:form action="add" methods="post">		
			<s:textfield name="user.username" label="用户名"/>
			<s:password name="user.password" label="密 码"/>
			<s:textfield name="user.email" label="邮  箱"/>
			<s:textfield name="user.address" label="地  址"/>
			<s:textfield name="user.birth"  format="yyyy-MM-dd" nice="false" label="出生日期"/>
			<!--<s:textfield name="user.birth" label="出生日期"/>-->
			<s:submit value="注册" align="center"/>
	</s:form>
</center>
</body>
</html>