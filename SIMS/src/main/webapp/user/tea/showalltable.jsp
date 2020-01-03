<%--
  Created by IntelliJ IDEA.
  User: Bo
  Date: 2020/1/3
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="refresh" content="5">   <%--5秒刷新一次--%>
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
        <li><a href="javascript:;">课程表</a></li>
        <li><a href="javascript:;">查看课程表</a></li>
    </ul>
</div>




<table class="tablelist">
    <thead>
    <tr>
        <th>节数/周几</th>
        <th>周一</th>
        <th>周二</th>
        <th>周三</th>
        <th>周四</th>
        <th>周五</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${alltable }" var="t" varStatus="count">

        <tr>
            <td><b>第${count.count}节</b></td>
           <c:forEach items="${t }" var="c">



            <c:if test="${fn:containsIgnoreCase(teacname, c)}" var="flag">
                <td style="color: #00ee00">${c}</td>
            </c:if>

               <c:if test="${not flag}" >
                   <td>${c}</td>
               </c:if>





            </c:forEach>
        </tr>

    </c:forEach>
    </tbody>
</table>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
