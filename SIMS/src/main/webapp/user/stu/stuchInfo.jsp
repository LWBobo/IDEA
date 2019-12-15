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


        function change() {

        }
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:;">首页</a></li>
        <li><a href="javascript:;">个人信息</a></li>
        <li><a href="javascript:;">查看个人信息</a></li>
    </ul>
</div>




<div class="rightinfo">

<div class="tools">

    <ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
    </ul>


    <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
    </ul>

</div>


    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
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

        </tbody>
        <form action="user" method="post" >
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${user.snum}</td>
                <input type="hidden" name="oper" value="chstuinfo"  />
                <td><input type="text" name="newname" placeholder="${user.sname}"></td>
                <td><input type="text" name="newsex" placeholder="${user.ssex}"></td>
                <td><input type="text" name="newtel" placeholder="${user.stel}"></td>
                <td><input type="text" name="newaddress" placeholder="${user.saddress}"></td>
                <td><input type="text" name="newbirthday" placeholder="<fmt:formatDate
                    type="both"
                    dateStyle="long" timeStyle="long"
                    value="${user.sbirthday}" />"></td>
                <td> <input type="submit" value="修改">    </td>
            </tr>
        </form>



    </table>



<div class="tip">
    <div class="tiptop"><span>提示信息</span><a></a></div>

    <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
            <p>是否确认对信息的修改 ？</p>
            <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
    </div>

    <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
    </div>

</div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>

