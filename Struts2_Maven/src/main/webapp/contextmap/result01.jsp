<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:debug></s:debug>

<h3>OGNL表达式取值</h3>   <hr>
<!-- 取值 <%--<s:property value=""/>--%>
	 value写的是OGNL表达
	 如果要取contextMap，写#+key名字
	 如果是取ValueStack，直接key名字
-->
<%--获取栈顶map的数据：
<%
    ValueStack valueStack  = ActionContext.getContext().getValueStack();
    String v1 = (String) valueStack.findValue("user.username");
    out.write(v1);
%> <br>--%>
<s:property value="user.username" />  <br>
<s:property value="user.password" /> <br>
取ValueStack的：<s:property value="[1].username"/><br>
取ValueStack的：<s:property value="[1].password"/><br>
取ValueStack的：<s:property value="[2].username"/><br>
取ValueStack的：<s:property value="[2].password"/><br>
取contextMap的：<s:property value="#username"/><br>
取contextMap的session的：<s:property value="#session.username"/><br>
取contextMap的request的：<s:property value="#request.username"/><br>
取contextMap的application的：<s:property value="#application.username"/><br>
</body>
</html>
