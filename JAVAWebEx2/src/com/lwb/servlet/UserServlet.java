package com.lwb.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lwb.pojo.User;
import com.lwb.service.UserService;
import com.lwb.service.impl.UserServiceImpl;

@WebServlet("/userin")
public class UserServlet extends HttpServlet {
	//声明日志对象
	Logger logger =Logger.getLogger(UserServlet.class);
	//获取service层对象
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			//调用登录处理方法
			checkUserLogin(req,resp);
		}else if("ges".equals(oper)){
			//调用猜数字功能
			guess(req,resp);
		}else if("logout".equals(oper)){
			//调用退出功能
			userOut(req,resp);
		}
		
	
}
	
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session对象
		HttpSession hs=req.getSession();
		//强制销毁session
		logger.debug(((User)hs.getAttribute("user")).getUname()+":退出登录" );
		hs.invalidate();
		//重定向到登录页面
		resp.sendRedirect("/ex2/login.jsp");
	}
	//处理登录
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
				//获取请求信息
				String uname=req.getParameter("uname");
				String pwd=req.getParameter("pwd");
				//处理请求信息
					//校验
					User u=us.checkUserLoginService(uname, pwd);
					if(u!=null){
						//创建猜数的对象
						int num = new Random().nextInt(100);
						int count = 0;  //猜数的次数
						//获取session对象
						HttpSession hs=req.getSession();
						//将用户数据存储到session中
						hs.setAttribute("user", u);
						//将数存储到session对象中
						hs.setAttribute("num", num);
						hs.setAttribute("count", count);
						//重定向
						resp.sendRedirect("main.jsp");
						return;
					}else{
						//添加标识符到request中
						req.setAttribute("flag",0);
						//请求转发
						req.getRequestDispatcher("/login.jsp").forward(req, resp);
						return;
					}
				//响应处理结果
					//直接响应
					//请求转发
					
					
	}
	
	private void guess(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession hs=req.getSession();
		String str = req.getParameter("userinnum");
		int real_num = (int) hs.getAttribute("num");
		int ges_count = (int) hs.getAttribute("count");
		ges_count++;
		hs.setAttribute("count", ges_count);
	//	System.out.println("userinnum:" + str + " " + "num:" + real_num);
		if(str.equals("")) {
			hs.setAttribute("nogas", 3);
			resp.sendRedirect("main.jsp");
		}else {
			int num = Integer.parseInt(str);
			if(num > real_num) {//猜大了
				logger.debug(((User)hs.getAttribute("user")).getUname()+"-"+(ges_count)+" :" + num + "-猜大了");
			//	hs.setAttribute("nogas", 1);
				resp.getWriter().write("1"+ "#" + ges_count);
			}else if(num < real_num) {//猜小了
				logger.debug(((User)hs.getAttribute("user")).getUname()+"-"+(ges_count)+ " :" + num + "-猜小了");
				//hs.setAttribute("nogas", -1);
				resp.getWriter().write("-1" + "#" + ges_count);
			}else {//猜对了
				logger.debug(((User)hs.getAttribute("user")).getUname()+"-"+(ges_count)+" :" + num + "-猜对了");
				//hs.setAttribute("nogas", 0);
				resp.getWriter().write("0"+ "#" + ges_count);
			}
			//resp.sendRedirect("main.jsp");
			
		}
		
	}
	
	
}
