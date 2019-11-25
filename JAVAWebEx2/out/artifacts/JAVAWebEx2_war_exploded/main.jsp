<%@ page import="com.lwb.pojo.User" %>
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
<title>主界面</title>
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

function send(){
	var ajax;
	 var ss = document.getElementById("userinnum").value;
	if (window.XMLHttpRequest){
		ajax = new XMLHttpRequest();
		}else {
			ajax = new ActiveXObject("Microsoft.XMLHTTP");
		}
	
	ajax.onreadystatechange = function () {
		if(ajax.readyState == 4 && ajax.status ==200 ){
			var textss = document.getElementById("result"); 
			var textss1 = document.getElementById("counts"); 
			var res = ajax.responseText;
			var strs= new Array();
			strs = res.split("#");
			var num = parseInt(strs[0]);
			textss1.innerHTML= "第" + strs[1]+ "次猜数" + "<br>";
			if(num == 0){
				textss.innerHTML= "猜对啦";
				shownum(3);
			}else if(num == 1){
				textss.innerHTML= "猜大啦";
			}else if(num == -1){
				textss.innerHTML= "猜小啦";
			}
			}
	};//状态改变的时候执行这个函数,用来判断是否请求完毕
	//设置传送方式,地址,以及同步还是异步
	ajax.open("GET","userin?oper=ges&userinnum=" + ss);
	ajax.send(null);//请求服务器
	
}
function shownum(i) {
    if (i == 0)
    window.location.href = 'trapage.jsp'; //跳转页面
    i--;
    if (i >= 0)
	setTimeout("shownum(" + i + ")", 1000); //每隔一秒调用shownum()函数	
    }
    shownum(i); //倒计时3S
</script>
</head>
<body>


<div >
 <p align="right">第<%= session.getAttribute("user_logincount") %>位访问者:<%=session.getAttribute("logintime") %></p>
</div>


<dl class="admin_login">
 <dt>
  <strong>游戏界面:<%= ((User)session.getAttribute("user")).getUname() %></strong>
  <span id="counts" style="font-size: 15px;font-weight: bold;"></span>
  	<!-- 提示文字框 -->
     <span id="result" style="font-size: 15px;color:darkred;font-weight: bold;"></span>
  
 </dt>
 <form action="userin" method="post">
 	<dd class="user_icon">
  <input type="hidden" name="oper" value="ges" />
  <input type="text" placeholder="输入猜测的数字" class="login_txtbx" id="userinnum" name="userinnum"/>
 </dd>

 <dd>
  <input type="button" value="提交" class="submit_btn" onclick="send()"/>
 </dd>
 </form>

 <dd>
  <p>201716040224 刘文博</p>
  <p>河南工业大学</p>
 </dd>
</dl>
</body>
</html>
