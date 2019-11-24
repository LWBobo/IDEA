<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
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
</script>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>登录界面</strong>
  <em>猜数字游戏</em>
      <%
    	//声明java代码块进行错误提示语的逻辑校验
    	Object obj=request.getAttribute("flag");
    	if(obj!=null){
    %>
	    <div style="text-align: center;">
	     <span style="font-size: 15px;color:darkred;font-weight: bold;">用户名或者密码错误</span>
	    </div>
    <%} %>
   
  
  
 </dt>
 <form action="userin" method="post">
 	<dd class="user_icon">
  <input type="hidden" name="oper" value="login" />
  <input type="text" placeholder="账号" class="login_txtbx" id="uname" name="uname"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" id="pwd" name="pwd"/>
 </dd>
 
 <dd>
  <input type="submit" value="立即登陆" class="submit_btn"/>
 </dd>
 </form>

 <dd>
  <p>201716040224 刘文博</p>
  <p>河南工业大学</p>
 </dd>
</dl>
</body>
</html>
