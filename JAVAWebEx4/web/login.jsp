<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<%@page import="java.lang.*" %>
<%@ page import="sun.misc.Request" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});

	//验证码部分
    var xmlHttp;          //定义ajax
    var status = 0;      //定义状态
    function createXMLHttp() {          //定义ajax请求方式
        if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        } else {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }


    //ajax发送并判断验证码
    function sendNumber() {                        //输入框显示
        var number = document.getElementById("code").value;
        if (number.length == 0) {                           //没有输入内容时还原输入框颜色及提示
            document.getElementById("code").value = "输入验证码";
            document.getElementById("code").style.color = "#CCC";
        } else if (number.length != 0) {                  // 有内容则发送
            sendRequest("verifycode/check.jsp?code=" + number);
        }
    }
    function sendRequest(url) {     ///发送验证请求
        createXMLHttp()
        xmlHttp.open("GET", url, true);    //设置获取方式，连接方式
        xmlHttp.onreadystatechange = handleResponse;//设置返回处理函数
        xmlHttp.send(null);
    }
    function handleResponse() {
        if (xmlHttp.readyState == 4) {
            if (xmlHttp.status == 200) {
                var res = xmlHttp.responseText;
                if (res == 0) {                                    //返回为0则验证通过
                 //   alert("验证码输入正确")
                    document.getElementById("a").innerHTML = "验证码正确";
                } else {                                            //返回其他则验证不通过
                //    alert("验证码输入错误")
                    document.getElementById("a").innerHTML = "验证码错误";
                }
            }
        }
    }

    ///显示刷新验证码图
    function loadimage() {
        document.getElementById("randImage").src = "verifycode/number.jsp?" + Math.random();
    }
    //向后台发送验证码
    function enterNumber() {
        var enter = document.getElementById("code").value;
        if (enter == "输入验证码") {
            document.getElementById("code").value = "";
            document.getElementById("code").style.color = "#000000";
        }
    }



</script> 

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span>
            <%--验证登录前的状态信息--%>
        <c:choose>
            <c:when test="${flag == 0 }">
                <div style="text-align: center;">
                    <span style="font-size: 15px;color:darkred;font-weight: bold;">用户名或者密码错误</span>
                </div>
            </c:when>
            <c:when test="${flag == 1 }">
                <div style="text-align: center;">
                    <span style="font-size: 15px;color:darkred;font-weight: bold;">请输入正确的验证码</span>
                </div>
            </c:when>
            <c:when test="${flag == 2 }">
                <div style="text-align: center;">
                    <span style="font-size: 15px;color:darkred;font-weight: bold;">密码修改成功</span>
                </div>
            </c:when>
            <c:when test="${flag == 3 }">
                <div style="text-align: center;">
                    <span style="font-size: 15px;color:darkred;font-weight: bold;">注册成功</span>
                </div>
            </c:when>
        </c:choose>
        <c:remove var="flag" scope="session"/>

        <%--声明验证码提示语--%>
        <div style="text-align: center;">
            <span id="a" style="font-size: 15px;color:darkred;font-weight: bold;"></span>
        </div>

    <div class="loginbox loginbox1">
    
    <form action="user" method="post">
    <input type="hidden" name="oper" value="login" />
    <ul>
    <li></li>
    <li><input name="uname" type="text" placeholder="用户名" class="loginuser" /></li>

        <li class="yzm">
    <span>
        <%--验证码输入区--%>
            <input type="text" id="code" name="code"
                   onblur="javascript:sendNumber();" title="输入验证码" value="输入验证码"
                   style="color: #CCC" onclick="javascript:enterNumber();" />

    </span>
            <cite>
                <%--验证码--%>
                <img name="randImage" id="randImage" src="verifycode/number.jsp"
                     onclick="javascript:loadimage();" />

            </cite>

        </li>

        <li><input name="pwd" type="password" placeholder="密码" class="loginpwd" /></li>
    <li><input name="" type="submit" class="loginbtn" value="登录"   /><label><a href="user/reg.jsp">注册</a></label></li>
    </ul>
    </form>
    
    </div>
    
    </div>
    
    
    <div class="loginbm">版权所有  刘文博  <a href="https://www.haut.edu.cn/">河南工业大学</a>  仅供学习交流，勿用于任何商业用途</div>
	
    
</body>

</html>
