<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- struts2标签库调用声明 -->
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>
	<center>
		<s:form action="login">
				<s:textfield name="username" label="用户名"/>
				<s:password name="password" label="密 码"/>
				<s:submit value="登录" align="center"/>
		</s:form>
		<a href="add.jsp">注册</a>
	</center>
</body>
</html>