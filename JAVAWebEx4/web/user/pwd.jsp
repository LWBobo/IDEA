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
<!-- 引入jQuary对象 -->
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#fm").submit(function(){
			if($("#newpwd1").val()==""){
				alert("新密码不能为空!");
				return false;
			}else if($("#newpwd2").val()==""){
				alert("确认密码不能为空!");
				return false;
			}else if($("#newpwd2").val()!=$("#newpwd1").val()){
				alert("两次密码不一致!");
				return false;
			}

		})

	})


</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:;">首页</a></li>
    <li><a href="javascript:;">个人信息</a></li>
    <li><a href="javascript:;">修改密码</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>修改密码</span></div>
    

    <form action="user" method="post" id="fm" target="_top">
     <ul class="forminfo">
     <input type="hidden" name="oper" value="pwd"  /> 
     <li><label>原密码</label><input name="oldpwd" type="password" class="dfinput" /><i></i></li>
     <li><label>新密码</label><input name="newpwd" type="password" id="newpwd1" class="dfinput" /><i></i></li>
     <li><label>确认新密码</label><input name="" type="password" id="newpwd2" class="dfinput" /><i></i></li>
     <li><label>&nbsp;</label><input name="" type="submit" class="loginbtn" value="确认保存"/></li>
     </ul>
 
    </form>
    
    </div>


</body>

</html>
