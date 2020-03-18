<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/2/21
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="account/testfindAll">测试查询所有</a>

<h3>测试保存</h3>
<form action="account/testSave" method="post">
    姓名：<input type="text" name="name"> <br>
    账户余额：<input type="text" name="money"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
