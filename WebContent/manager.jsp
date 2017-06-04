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
<body><center>
	欢迎管理员<br/>
	   <table border="1">
			<tr>
			<td>姓名</td>
			<td>密码</td>
			<td>地址</td>
			<td>邮箱</td>
			<td>出生日期</td>
			</tr>
		  <s:iterator value="list" status="li">
		  <tr>
			<td><s:property value="username"/></td>
			<td><s:property value="password"/></td>
			<td><s:property value="address"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="birth"/></td>
			</tr>
		</s:iterator>
		</table>
		</center>
</body>
</html>