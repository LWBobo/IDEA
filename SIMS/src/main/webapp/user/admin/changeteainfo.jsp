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

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:;">首页</a></li>
        <li><a href="javascript:;">管理信息</a></li>
        <li><a href="javascript:;">修改教师信息</a></li>
    </ul>
</div>




<table class="tablelist">
    <thead>
    <tr>
        <th>教师ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>教师姓名</th>
        <th>性别</th>
        <th>职称</th>
        <th>出生年月</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teachers}" var="t">
        <form action="user" method="post">
            <tr>

                <td> ${t.tnum}</td>
                <input type="hidden" name="oper" value="adminupdateteainfo">
                <input type="hidden" name="tnum" value="${t.tnum}">
                <td><input type="text" name="newtname" placeholder="${t.tname}"></td>
                <td><input type="text" name="newtsex" placeholder="${t.tsex}"></td>
                <td><input type="text" name="newttitle" placeholder="${t.ttitle}"></td>
                <td><input type="text" name="newtbirthday" placeholder=" <fmt:formatDate
                                type="date" dateStyle="long" timeStyle="long" value= "${t.tbirthday}" />">
                   </td>
                <td><input type="submit" name="submit" value="确认修改"> </td>
                <td></td>
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
