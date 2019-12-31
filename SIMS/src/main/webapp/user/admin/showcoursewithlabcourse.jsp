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
        <li><a href="javascript:;">查看课程信息</a></li>
    </ul>
</div>




<table class="tablelist">

    <tbody>
    <c:forEach items="${coursewithlabcourse}" var="c">
    <thead>
    <tr>
        <th>所选课程<i class="sort"><img src="images/px.gif" /></i></th>
        <th>课程名</th>
        <th>课程学分</th>
        <th>开课时间</th>
        <th>结课时间</th>
        <th>授课教师</th>

    </tr>
    </thead>

    <tr>
        <td>${c.cnum }</td>
        <td>${c.cname }</td>
        <td>${c.ccredit }</td>
        <td><fmt:formatDate type="date"
                            value="${c.cbegintime}" /></td>
        <td><fmt:formatDate type="date"
                            value="${c.cendtime}" /></td>
        <td>${c.teacher.tname}</td>

    </tr>


    <c:if test="${c.cislabcourse == 1}">

        <tr>
            <td><b>所属实验课</b></td>
            <td>实验课编号:<b>${c.labcourse.lcnum }</b></td>
            <td>实验课名:<b>${c.labcourse.lcname }</b></td>

            <td>教室编号:<b>${c.labcourse.lcclassroomnumber }</b></td>
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