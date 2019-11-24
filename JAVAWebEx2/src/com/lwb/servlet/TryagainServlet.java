package com.lwb.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lwb.pojo.User;

/**
 * Servlet implementation class TryagainServlet
 */
@WebServlet("/again")
public class TryagainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logger logger =Logger.getLogger(TryagainServlet.class);
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		HttpSession hs= req.getSession();
		hs.setAttribute("num", new Random().nextInt(100));   //重新生成数字
	    hs.setAttribute("count", 0); 					//猜的次数重置
	    logger.debug(((User)hs.getAttribute("user")).getUname()+":再次发起猜数字");
	    resp.sendRedirect("main.jsp");
	}

}
