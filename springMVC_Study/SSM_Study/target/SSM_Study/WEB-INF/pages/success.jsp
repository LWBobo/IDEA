<%--
  Created by IntelliJ IDEA.
  User: 博
  Date: 2020/1/20
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>入门成功了</h3>
${user.toString()}
<%=session.getAttribute("user") %>


</body>
</html>
