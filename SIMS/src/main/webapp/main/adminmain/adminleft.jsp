<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#fff3e1;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>个人信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="javascript:;" target="rightFrame">查看个人信息</a><i></i></li>
         <li><cite></cite><a href="user/pwd.jsp" target="rightFrame">修改密码</a><i></i></li>
            <li><cite></cite><a href="user/msboard.jsp" target="rightFrame">添加留言</a><i></i></li>
        </ul>    
    </dd>
        <dd>
            <div class="title">
                <span><img src="images/leftico01.png" /></span>管理信息
            </div>
            <ul class="menuson">


                <li><cite></cite><a href="user?oper=showcourse" target="rightFrame">查看课程信息</a><i></i></li>

                <li>
                    <div class="header">
                        <cite></cite>
                        <a href="user?oper=showteainfo" target="rightFrame">查看教师信息</a>
                        <i></i>
                    </div>
                    <ul class="sub-menus">
                        <li><a href="user/admin/showteainfowithcourse.jsp" target="rightFrame">查看教师详细信息</a></li>

                    </ul>
                </li>



                <li>
                    <div class="header">
                        <cite></cite>
                        <a href="user?oper=showstudent" target="rightFrame">查看学生信息</a>
                        <i></i>
                    </div>
                    <ul class="sub-menus">
                        <li><a href="user/tea/showstudentwithcourse.jsp" target="rightFrame">查看详细学生信息</a></li>

                    </ul>
                </li>

                <li><cite></cite><a href="user/admin/changecourseinfo.jsp" target="rightFrame">修改课程信息</a><i></i></li>
                <li><cite></cite><a href="user/admin/changeteainfo.jsp" target="rightFrame">修改教师信息</a><i></i></li>
                <li><cite></cite><a href="user/admin/changestuinfo.jsp" target="rightFrame">修改学生信息</a><i></i></li>


        </dd>

        <dd>
            <div class="title">
                <span><img src="images/leftico01.png" /></span>留言板
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="user?oper=showallmessage" target="rightFrame">查看留言板</a><i></i></li>
                <li><cite></cite><a href="user/showmymsboard.jsp" target="rightFrame">管理我的留言</a><i></i></li>
            </ul>
        </dd>
    </dl>
</body>
</html>
 