<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>struts的国际化</h3>
<hr>
<form action="${pageContext.request.contextPath}/login.action">
		<s:text name="login.username"/> <input type="text" name="username"><br>
		<s:text name="login.password"/><input type="password" name="password"><br>
		<input type="submit" value="<s:text name="login.submit"/>">
</form>
</body>
</html>