<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/2/24
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"  %>
<html>
<head>
    <title>Title</title>
    <s:head></s:head>
</head>
<body>
StrutsForm标签
<s:form action="login" method="POST">
    <!--
    requiredLabel:代表必填项目
    requiredPosition:必填*号位置
    showPassword:回显时，密码还在
    -->
    <s:textfield name="username" label="用户名" requiredLabel="true" requiredPosition="left"></s:textfield>
    <s:password name="password" label="密码"></s:password>
<%--    <s:checkbox name="hobby" label="写代码" value="写代码"></s:checkbox>
    <s:checkbox name="hobby" label="打游戏" value="打游戏"></s:checkbox>--%>
    <s:checkboxlist list="{'写代码','看电影','打游戏'}" name="hobby" label="爱好"></s:checkboxlist>
    <s:radio list="{'已婚','未婚'}" label="是否已婚" name="married" ></s:radio>
    <s:submit value="提交"></s:submit>
</s:form>
<hr>
<h4>token防止表单重复提交</h4>
<form action="login">
    用户名<input type="text" name="username"><br>
    密码<input type="password" name="password"><br>
    <s:token></s:token>
    <input type="submit" name="登录">
</form>
<hr>
封装到模型
<form action="login2">
    用户名<input type="text" name="user.name"><br>
    密码<input type="password" name="user.password"><br>
    <input type="submit" name="登录">
</form>
<hr>
通过模型驱动
<form action="login3">
    用户名<input type="text" name="name"><br>
    密码<input type="password" name="password"><br>
    <input type="submit" name="登录">
</form>
</body>
</html>
