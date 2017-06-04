<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- struts2标签库调用声明 -->
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("gbk");
	%>
	
	${message }
	${user.getUsername() }
	${user.getPassword() }
	${user.getAddress() }
	${user.getEmail() }
	${user.getBirth() }
</body>
</html>