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
<!-- struts表单的特点
1.action不需要写项目名，会自动加
2.会给表单里面的内容放在table中，并加上样式
3.struts的表单项必须要有name
 -->
Struts的Form标签<br>
<%-- <s:fielderror></s:fielderror> --%>
<s:form action="/user/register.action">
	<!--  
	requiredLabel:代表必填项目
	requiredPosition:必填*号位置
	showPassword:回显时，密码还在
	-->
	<s:textfield name="username" label="用户名" requiredLabel="true" requiredPosition="left"></s:textfield>
	<s:password name="password" label="密码" showPassword="true"></s:password>
	<s:textfield name="birthday" label="生日"></s:textfield>
	<%-- <s:checkbox name="hobby" label="写代码" value="写代码"></s:checkbox>
	<s:checkbox name="hobby" label="泡妞" value="泡妞"></s:checkbox>
	<s:checkbox name="hobby" label="买房" value="买房"></s:checkbox> --%>
	<!-- list使用的OGNL表达式 -->
	<s:checkboxlist list="{'写代码','泡妞','买房'}" label="爱好" name="hobby"></s:checkboxlist>
	<s:radio list="#{'true':'已婚','false':'未婚'}" name="married" label="是否已婚"></s:radio>

	<s:submit value="注册"></s:submit>
</s:form>
</body>
</html>