package com.lwb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
				resp.getWriter().write("-1");
				String s1 = req.getParameter("oper");
				String s2 = req.getParameter("userinnum");
				System.out.println("opera:" + s1 + "  " +"userinname:" + s2);
				
			}

}
