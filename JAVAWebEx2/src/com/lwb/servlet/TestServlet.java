package com.lwb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
			@Override
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//设置请求编码格式
				req.setCharacterEncoding("utf-8");
				//设置响应编码格式
				resp.setContentType("text/html;charset=utf-8");
				ServletContext sc=this.getServletContext();
				System.out.println(sc.getAttribute("nums"));
				if(sc.getAttribute("nums")!=null){
					int nums=(int) sc.getAttribute("nums");
					//计数器自增
					nums+=1;
					//再次存储到ServletContext对象中
					sc.setAttribute("nums", nums);
				}else{
					sc.setAttribute("nums", 1);
				}
				
			}

}
