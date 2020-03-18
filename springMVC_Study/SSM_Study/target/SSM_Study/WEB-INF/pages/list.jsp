<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/2/21
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>查询成功</h3>
<c:forEach items="${list}" var="account">
    ${account.name} <br>
    ${account.money} <br>

</c:forEach>
</body>
</html>
