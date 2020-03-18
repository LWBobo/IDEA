<%--
  Created by IntelliJ IDEA.
  User: 博
  Date: 2020/2/5
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>测试jababean的封装传输</title>
</head>
<body>
     <%=basePath%><br>
     <%=path%>

    <form action="user/userbean" method="post">
        姓名：<input type="text" name="name" >
        性别：<input type="text" name="sex" >
        <%--金额：<input type="text" name="list[0].account" >--%>
        <%--余额：<input type="text" name="list[0].money" >--%>
        金额：<input type="text" name="map['one'].account" >
        余额：<input type="text" name="map['one'].money">
        <input type="submit" value="提交">
    </form>
</body>
</html>
