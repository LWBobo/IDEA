<%@ page import="com.opensymphony.xwork2.util.ValueStack" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h3>iterator遍历(OGNL投影)</h3> <hr>
<table border="1">
    <tr>
        <td>状态</td>
        <td>名字</td>
        <td>年龄</td>
        <td>城市</td>
    </tr>
    <!-- 使用struts的遍历标签
         1.value:写值栈变量名
         2.var:遍历的变量名,存到contextMap
         2.status:遍历的状态
    -->
    <%--OGNL投影--%>
    <%--一、OGNL投影:是指可以给定过滤条件
            OGNL表达试加条件
            > .?#过滤所有符合条件的集合如: stulist. {?#this . age>30}
            > .^#过滤第一个符合条件的集合如: stulist. {^#this . age>30}
            > .$#过滤最后一个符合系的集合如: stuList . {$#this . age>30}
    --%>
     <s:iterator value="stuList.{?#this.age>=18}" var="stu" status="st">
        <tr>
            <td>${st.count} </td>
            <td><s:property value="#stu.name"/> </td>
            <td><s:property value="#stu.age"/></td>
            <td><s:property value="#stu.city"/></td>
        </tr>
    </s:iterator>

</table>
<h3>EL遍历</h3> <hr>
<table border="1">

    <tr>
        <td>状态</td>
        <td>名字</td>
        <td>年龄</td>
        <td>城市</td>
    </tr>


    <s:iterator value="stuList" var="stu" status="st">

        <tr>
            <td>${st.count}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.city}</td>
            <td></td>

        </tr>
    </s:iterator>


</table><hr>
<a href="../tag.jsp">练习其他标签</a>
</body>
</html>
