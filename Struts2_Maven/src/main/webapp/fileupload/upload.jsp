<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/2/29
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>文件上传</h3> <hr>
<s:actionerror></s:actionerror>
<s:form action="fileupload/upload" enctype="multipart/form-data" method="post">
    <s:textfield label="用户名" name="username"/>
    <s:textfield label="密码" name="password"/>
    <s:file label="照骗" name="photo"/>
    <s:submit value="上传" />
</s:form>

</body>
</html>
