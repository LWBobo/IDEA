<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.lwb.pojo.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>回答正确</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js" tppabs="js/verificationNumbers.js"></script>
<script src="js/Particleground.js" tppabs="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });

	});
	function again(){
		location.href="again";
	}

	function logout(){
		var flag=window.confirm("你真的要退出吗?");
		if(flag){
			location.href="userin?oper=logout";
		}
		
	}
</script>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong style="color:darkred;">恭喜<%= ((User)session.getAttribute("user")).getUname() %></strong>
  <em style="color:darkred;">猜对啦</em>
  
 </dt>
 	<dd >
 	<input type="text"  value="<%="正确答案:" + application.getAttribute("num") %>" class="login_txtbx" id="uname" name="uname"/>
 </dd>
 <dd >
  <input type="text"   value="<%="猜测次数:" + session.getAttribute("count") %>" class="login_txtbx" id="pwd" name="pwd"/>
 </dd>
 
 <dd>
  <input type="button" value="再来一次" class="submit_btn" onclick="again()"/> 
 </dd>
  <dd>
  <input type="button" value="退出" class="submit_btn" onclick="logout()"/> 
 </dd>

 <dd>
  <p>201716040224 刘文博</p>
  <p>河南工业大学</p>
 </dd>
</dl>
</body>
</html>
