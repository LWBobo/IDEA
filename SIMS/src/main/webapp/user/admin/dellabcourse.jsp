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
        <li><a href="javascript:;">其他信息</a></li>
        <li><a href="javascript:;">添加实验课</a></li>
    </ul>
</div>




<table class="tablelist">

    <tbody>
    <thead>
    <tr>
        <th>所选课程<i class="sort"><img src="images/px.gif" /></i></th>
        <th>课程名</th>
        <th>实验课程号</th>
        <th>实验课名称</th>
        <th>实验地点</th>
        <th>操作</th>

    </tr>
    </thead>
    <c:forEach items="${coursewithlabcourse}" var="c">

        <c:if test="${c.cislabcourse == 1}">
            <tr>
                <td>${c.cnum }</td>
                <td>${c.cname }</td>
                <td>${c.labcourse.lcnum }</td>
                <td>${c.labcourse.lcname}</td>
                <td>${c.labcourse.lcclassroomnumber}</td>
                <td><a href="table?oper=dellabcourse&cnum=${c.cnum}" style="color: #ee150a">删除实验课</a> </td>

            </tr>


        </c:if>


    </c:forEach>

    </tbody>
</table>


<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>