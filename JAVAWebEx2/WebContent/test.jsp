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
<script type="text/javascript">
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
	 alert(ss);
	if (window.XMLHttpRequest){
		ajax = new XMLHttpRequest();
		}else {
			ajax = new ActiveXObject("Microsoft.XMLHTTP");
		}
	
	ajax.onreadystatechange = function () {
		if(ajax.readyState == 4 && ajax.status ==200 ){
			var textss = document.getElementById("result"); 
			var res = ajax.responseText;
			var num = parseInt(res);
			if(num == 0){
				textss.innerHTML= "猜对啦";
			}else if(num == 1){
				textss.innerHTML= "猜大啦";
			}else if(num == -1){
				textss.innerHTML= "猜小啦";
			}
			if(res == "ajaxtest"){
				shownum(3);
			}
			}
	};//状态改变的时候执行这个函数,用来判断是否请求完毕
	//设置传送方式,地址,以及同步还是异步
	ajax.open("GET","test?oper=ges&userinnum=" + ss);
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
<dl class="admin_login">
 <dt>
  <strong>游戏界面</strong>
  <em>第<%=session.getAttribute("count") %>次猜数</em>
  
      <span id="result" style="font-size: 15px;color:darkred;font-weight: bold;"></span>
<!--   <div id="result" style="width:200px">  
       </div>  --> 
 </dt>
 	<dd class="user_icon">
  <input type="hidden" name="oper" value="ges" />
  <input type="text" placeholder="输入猜测的数字" class="login_txtbx" id="userinnum" name="userinnum" />
 </dd>

 <dd>
  <input type="button" value="提交" class="submit_btn" onclick="send()" />
 </dd>
 

 <dd>
  <p>201716040224 刘文博</p>
  <p>河南工业大学</p>
 </dd>
</dl>
</body>
</html>
