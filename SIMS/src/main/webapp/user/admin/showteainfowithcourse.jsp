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
        <li><a href="javascript:;">查看教师详细信息</a></li>
    </ul>
</div>







    <c:forEach items="${teachers}" var="t">
    <table class="tablelist">
    <thead>
    <tr>
        <th>教师ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>教师姓名</th>
        <th>性别</th>
        <th>职称</th>
        <th>出生年月</th>
    </tr>
    </thead>
        <tbody>
        <tr>

            <td>${t.tnum}</td>
            <td>${t.tname}</td>
            <td>${t.tsex}</td>
            <td>${t.ttitle}</td>
            <td><fmt:formatDate type="date" dateStyle="long" timeStyle="long" value= "${t.tbirthday}" /></td>

        </tr>
        </tbody>

        <table class="tablelist">
            <thead>
            <tr>
                <th>教授课程<i class="sort"><img src="images/px.gif" /></i></th>
                <th>课程名</th>
                <th>课程学分</th>
                <th>开课时间</th>
                <th>结课时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${t.courses}" var="c">
                <tr>
                    <td>${c.cnum }</td>
                    <td>${c.cname }</td>
                    <td>${c.ccredit }</td>
                    <td><fmt:formatDate type="date"
                                        value="${c.cbegintime}" /></td>
                    <td><fmt:formatDate type="date"
                                        value="${c.cendtime}" /></td>

                </tr>

            </c:forEach>

            </tbody>
        </table>

    </table>
    </c:forEach>






<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
