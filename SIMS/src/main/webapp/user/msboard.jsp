<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
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
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="javascript:;">首页</a></li>
        <li><a href="javascript:;">个人信息</a></li>
        <li><a href="javascript:;">添加留言</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>

    <form action="user" method="post" id="fm" target="_top">
    <ul class="forminfo">
        <input type="hidden" name="oper" value="addboard" >
        <li><label>留言标题</label><input name="mstitle" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
        <li><label>关键字</label><input name="mskeyword" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
        <li><label>留言内容</label><textarea name="msinfo" cols="" rows="" class="textinput"></textarea></li>
        <li><label>&nbsp;</label><input name="" type="submit" class="loginbtn" value="确认保存"/></li>
    </ul>
    </form>


</div>


</body>

</html>