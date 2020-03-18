<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>普通方式的国际化</h3>
<hr>
<%
	Locale local = Locale.getDefault();//获取到一个默认的国家语言
	ResourceBundle rb = ResourceBundle.getBundle("message", local);
%>
<%=local %>
<form action="${pageContext.request.contextPath}/login.action">
	<%=rb.getString("login.username")%><input type="text" name="username"><br>
	<%=rb.getString("login.password")%><input type="password" name="password"><br>
	<input type="submit" value="<%=rb.getString("login.submit")%>">
</form>
</body>
</html>