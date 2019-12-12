<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" pageEncoding="UTF-8" import="com.lwb.pojo.MD5"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<%
	String num = request.getParameter("code");
	String random = (String) session.getAttribute("rCode");
	MD5 md5=new MD5();
	if (num != null && random != null) {
	String md5num=md5.gernerateMD5(num);
		if (!md5num.equals(random)) {
			session.setAttribute("vcistrue",1);
			out.print("1");
		} else {
			session.setAttribute("vcistrue", 0);   //输对了
			out.print("0");
		}
	}
%>


