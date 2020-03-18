<%--
  Created by IntelliJ IDEA.
  User: bo
  Date: 2020/3/1
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>OGNL表达式</title>
</head>
<!-- OGNL表达式
	首先：要在jsp页面导入<%-- <%@ taglib uri="/struts-tags" prefix="s"%> --%>
	OGNL的作用:
	1.取值，或者说输入数据到jsp页面
		s:property的value不写单引号，代表要从作用域取值,如果写了单引号，但表它就是一个字符串
	2.调用方法
	3.访问静态属性/方法
	  默认情况下，strut2把静态属性的访问禁止，如果要使用，打开
	4.封装List数据，数组用花括号
	  <%--<s:radio list="{'男','女'}" name="gender" label="性别"/>--%>
	5.封装Map数据,用<%--#{'key1':'value1','key2':'value2'}--%>
 -->

<body>
<h3>OGNL表达式</h3> <hr>
<s:property value="'java-struts2'"/> 的长度
<s:property value="'java-struts2'.length()"/><br>
int的最大值 <s:property value="@java.lang.Integer@MAX_VALUE"/><br>
随机数<s:property value="@java.lang.Math@random()"/><br>
<s:radio list="{'男','女'}" name="gender" label="性别"/> <br>
<s:radio list="#{'male':'男','female':'女'}" name="gender" label="性别"/> <br>
</body>
</html>
