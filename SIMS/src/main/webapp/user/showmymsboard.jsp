<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:;">首页</a></li>
        <li><a href="javascript:;">个人信息</a></li>
        <li><a href="javascript:;">管理我的留言</a></li>
    </ul>
</div>






    <table class="tablelist">
        <thead>
        <tr>
            <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
            <th>用户名</th>
            <th>留言标题</th>
            <th>留言关键字</th>
            <th>留言信息</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>


        <c:forEach items="${myboard }" var="m">
        <form action="user" method="post">
            <tr>
                <td>${m.uid }</td>
                <td>${m.uname }</td>
                <input type="hidden" name="oper" value="updatemessage">
                <input type="hidden" name="msid" value="${m.msid}">
                <td><input placeholder="${m.mstitle }" name="mstitle"> </td>
                <td><input placeholder="${m.mskeyword }" name="mskeyword"> </td>
                <td><input placeholder="${m.mscontents }" name="mscontents"></td>
                <td><a href="user?oper=delmessage&msid=${m.msid}">删除</a>/<input type="submit" name="修改" value="修改"> </td>


            </tr>

        </form>
        </c:forEach>
        </tbody>




    </table>



<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>

