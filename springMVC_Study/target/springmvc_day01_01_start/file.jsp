<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/2/19
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>传统文件上传</h3>

<form action="file/fileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="传统方式上传文件"/>
</form>

<h3>springMVC文件上传</h3>

<form action="file/mvcfileUpload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload"/><br/>
    <input type="submit" value="springMVC方式上传文件"/>
</form>
</body>
</html>
