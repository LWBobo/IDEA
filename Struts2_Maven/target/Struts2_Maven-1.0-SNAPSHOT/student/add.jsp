<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/2/23
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <s:head></s:head>
</head>
<body>

<hr>
<s:debug></s:debug>
添加学生
<s:actionerror/>
<s:form action="/user/add.action">
    <s:textfield name="username" label="用户名"/>
    <s:textfield name="age" label="年龄"/>
    <s:textfield name="email" label="邮箱"/>
    <s:textfield name="password" label="密码"/>
    <s:textfield name="repassword" label="确认密码"/>
    <s:textfield name="score" label="成绩"/>
    <s:textfield name="url" label="个人主页"/>
    <s:radio list="{'男','女'}" name="gender" label="性别"></s:radio>
    <s:submit value="提交"/>

</s:form>
</body>
</html>