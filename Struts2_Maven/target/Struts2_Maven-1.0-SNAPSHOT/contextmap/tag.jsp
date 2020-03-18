<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h2>set标签</h2> <hr>

<!-- s:set标签
	往作用域存数据
	value:值
	var:变量名
	scope:作用域,范围,可写类型:application,session,request,page和action
	      不写，就是action
 -->
<s:set value="'applicationgyf01'" var="username1" scope="application"></s:set>
<s:set value="'sessiongyf02'" var="username2" scope="session"></s:set>
<s:set value="'requestgyf03'" var="username3" scope="request"></s:set>
<s:set value="'actiongyf04'" var="username4" scope="action"></s:set>

<!-- 取值 -->
<s:property value="#application.username1"/>   <br>
<s:property value="#session.username2"/>    <br>
<s:property value="#request.username3"/>    <br>
<s:property value="#action.username4"/>    <br>
<s:debug></s:debug>

<h2>action标签</h2> <hr>
<%--在页面显示另一个动作--%>
<s:action name="test02" executeResult="true"></s:action>

<h2>a标签</h2> <hr>
<s:a action="login">
    <s:param name="username">liuwenbo</s:param>
    <s:param name="password">123</s:param>
    点击

</s:a>

</body>
</html>
