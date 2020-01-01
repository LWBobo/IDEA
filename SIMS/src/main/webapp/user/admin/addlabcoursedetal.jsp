<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/select.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
    <script type="text/javascript" src="js/select-ui.min.js"></script>
    <script type="text/javascript" src="editor/kindeditor.js"></script>

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

    <script type="text/javascript">
        KE.show({
            id : 'content7',
            cssPath : './index.css'
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function(e) {
            $(".select1").uedSelect({
                width : 345
            });
            $(".select2").uedSelect({
                width : 167
            });
            $(".select3").uedSelect({
                width : 100
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
        <li><a href="javascript:;">填写实验课信息</a></li>
    </ul>
</div>



<form action="table" method="post">
<table class="tablelist">

    <tbody>
    <thead>
    <tr>
        <th>实验课号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>实验课程名</th>
        <th>对应课程号</th>
        <th>对应课程名</th>
        <th>实验教室</th>
    </tr>
    </thead>

        <input type="hidden" name="oper" value="addlabsinfo"/>
    <input type="hidden" name="labccnum" value="${labcourseinfo.cnum }">
    <input type="hidden" name="labccname" value="${labcourseinfo.cname }">



            <tr>
                <td>${labcourseinfo.cnum }X</td>   <%--实验课程号--%>
                <td><input name="labcname" placeholder="填入实验课程名"></td>
                <td>${labcourseinfo.cnum }</td>
                <td>${labcourseinfo.cname }</td>

                <td>
                    <select class="select3" name="labroom" >
                        <c:forEach items="${alllab}" var="lab">
                            <option>${lab.labnum}</option>
                        </c:forEach>

                    </select>
                </td>


            </tr>


    </tbody>
</table>
<%--     --%>





<table class="tablelist">
    <thead>
    <tr>
        <th>节次/周</th>
        <th>周一</th>
        <th>周二</th>
        <th>周三</th>
        <th>周四</th>
        <th>周五</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${addlabcoursetabletemp }" var="t" varStatus="rowcount">

        <tr>
            <td>第${rowcount.count}节</td>
            <c:forEach items="${t }" var="c" varStatus="linecount">
                <c:if test="${empty c}">

                       <%-- <td>${rowcount.count}行${linecount.count}列</td>--%>
                    <td><input type="checkbox" name="classchoice" value="${rowcount.count}-${linecount.count}" id="3" ><a style="color: #00ee00">选择</a> </td>
                </c:if>

                <c:if test="${not empty c}">
                    <td>${c}</td>
                </c:if>




            </c:forEach>
        </tr>

    </c:forEach>


    </tbody>
</table>

<input type="submit" name="提交" value="提交">

</form>





<script type="text/javascript">
    $("#usual1 ul").idTabs();
</script>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>