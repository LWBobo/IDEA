<%--
  Created by IntelliJ IDEA.
  User: 博
  Date: 2020/1/20
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC入门</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                   alert("hello btn");
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"name":"haha","password":"123","age":20}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //服务器端响应的json数据，进行解析
                        alert(data)
                        alert(data.name)
                    }
                })
            });
        });
    </script>

</head>
<body>
<h3>入门程序</h3>

<form action="user/testModoAttribute" method="post">
    姓名：<input type="text" name="name" >
    性别：<input type="text" name="sex" >
    <input type="submit" value="提交">
</form>

<a href="user/testVoid" >testVoid</a>
<br>
<a href="user/testForwardOrRedirect" >testForwardOrRedirect</a>

<br>

<button id="btn">发送aiax的异步请求</button>
<br>
<a href="file.jsp">文件上传</a>
<br>
<a href="exception.jsp">异常处理</a>
<br>
<a href="interceptor.jsp">拦截器</a>

</body>
</html>
