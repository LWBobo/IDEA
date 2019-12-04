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
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<script language="JavaScript">

    function relogin() {
        var flag=window.confirm("确定要重新登录吗?");
        if(flag){
            window.top.location.href="user?oper=out"
        }
    }

    function count() {
        var date = new Date();//当前时间
        document.getElementById("div1").innerHTML =  date.toLocaleString();
        var t = date.getHours();
        if(t<10 && t>6){
            document.getElementById("div2").innerHTML = "早上";
        }else if(t>10 && t < 14){
            document.getElementById("div2").innerHTML = "中午";
        }else if(t>14 && t < 18){
            document.getElementById("div2").innerHTML = "下午";
        }else{
            document.getElementById("div2").innerHTML = "晚上";
        }

        setTimeout("count()", 1000);
    }
    window.onload = count;
</script>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">

    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
        <b><i>${user.uname}</i><i id="div2"></i> 好，欢迎使用信息管理系统</b>
    <a href="user/pwd.jsp">帐号设置</a>
    </div>


    <div class="welinfo">



    <span><img src="images/time.png" alt="时间" /></span>
    <i>当前时间：<i id="div1"></i> </i> （不是您登录的？<a href="javascript:void(0)" onclick="relogin()">请点这里 </a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="images/ico01.png" /><p><a href="#">管理设置</a></p></li>
    <li><img src="images/ico02.png" /><p><a href="#">发布文章</a></p></li>
    <li><img src="images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="images/ico04.png" /><p><a href="#">文件上传</a></p></li>
    <li><img src="images/ico05.png" /><p><a href="#">目录管理</a></p></li>
    <li><img src="images/ico06.png" /><p><a href="#">查询</a></p></li> 
            
    </ul>
    
    <div class="ibox"><a class="ibtn"><img src="images/iadd.png" />添加新的快捷功能</a></div>
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>Uimaker信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行文章发布管理操作</span><a class="ibtn">发布或管理文章</a></li>
    <li><span>您可以快速发布产品</span><a class="ibtn">发布或管理产品</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>


</body>

</html>
