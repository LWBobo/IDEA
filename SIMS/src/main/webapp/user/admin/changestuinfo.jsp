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
        <li><a href="javascript:;">修改学生信息</a></li>
    </ul>
</div>




<table class="tablelist">
    <thead>
    <tr>
        <th>用户ID<i class="sort"><img src="images/px.gif" /></i></th>
        <th>用户名</th>
        <th>性别</th>
        <th>联系方式</th>
        <th>地址</th>
        <th>出生年月</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${students}" var="s">
       <form action="user" method="post">
           <tr>
               <input type="hidden" name="oper" value="adminupdatestuinfo">
               <input type="hidden" name="snum" value="${s.snum}">

               <td>${s.snum}</td>
               <td><input type="text" name="newsname" placeholder="${s.sname}" ></td>
               <td><input type="text" name="newssex" placeholder="${s.ssex}" ></td>
               <td><input type="text" name="newstel" placeholder="${s.stel}" ></td>
               <td><input type="text" name="newsaddress" placeholder="${s.saddress}"> </td>
               <td><input type="text" name="newsbirthday" placeholder=" <fmt:formatDate
                       type="date"
                       dateStyle="long" timeStyle="long"
                       value="${s.sbirthday}" />"></td>
               <td><input type="submit" name="submit" value="确认修改"> </td>
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
