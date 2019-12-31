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


        //ajax发送并判断密码
        function showHint() {
            //输入框显示
            var number = document.getElementById("oldpwd").value;
            sendRequest("ajax?oper=changepwd&newpwd=" + number);
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
                    //alert(res);
                    document.getElementById("a").innerHTML = res;

                }
            }
        }


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
            <li><label>原密码</label><input name="oldpwd" type="password" class="dfinput" onkeyup="showHint()" id="oldpwd"/><i id="a"></i></li>
            <li><label>新密码</label><input name="newpwd" type="password" id="newpwd1" class="dfinput" /><i></i></li>
            <li><label>确认新密码</label><input name="" type="password" id="newpwd2" class="dfinput" /><i></i></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="loginbtn" value="确认保存"/></li>
        </ul>

    </form>

</div>


</body>

</html>
