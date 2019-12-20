package com.lwb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;
import javax.xml.crypto.Data;

import com.lwb.pojo.Course;
import com.lwb.pojo.Student;
import com.lwb.pojo.Teacher;
import com.lwb.pojo.Users;
import com.lwb.service.UserService;
import com.lwb.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Servlet重定向路径总结：
 * 	相对路径：从当前请求的路径查找资源的路径
 * 		相对路径如果servlet的别名中包含目录，会造成重定向资源查找失败。
 * 	绝对路径：第一个/表示服务器根目录
 * 		/虚拟项目名/资源路径
 * 
 * Servlet请求转发：
 * 		/表示项目根目录。
 * 		req.getRequestDispatcher("/资源路径").forward(req, resp);
 * 
 * @author MyPC
 *
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	//声明日志对象
	Logger logger =Logger.getLogger(UserServlet.class);
	//获取service层对象

	UserService us = new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		
		//获取操做符
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			//调用登录处理方法
			checkUserLogin(req,resp);
		}else if("pwd".equals(oper)){
			//调用密码修改功能
			userChangePwd(req,resp);
		}else if("out".equals(oper)){
			//调用退出功能
			userOut(req,resp);
		}else if("showcourse".equals(oper)){
			//调用显示所有课程功能
			showAllCourse(req,resp);
		}else if("chstuinfo".equals(oper)){
			//调用更改学生信息功能
			try {
				chStuInfo(req,resp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if("showstudent".equals(oper)){
			//调用显示所有学生信息功能
			showAllStudent(req,resp);
		}else if("showteainfo".equals(oper)){
			//调用显示所有学生信息功能
			showAllTeacher(req,resp);
		}else{
			logger.debug("没有找到对应的操作符："+oper);
		}




	}


	//显示所有的课程信息
	private void showAllCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<Course> lu=us.showAllCourse();
			HttpSession hs=req.getSession();
			//判断
			if(lu!=null){
				//将查询的用户数据存储到request对象
				hs.setAttribute("lu",lu);
				//请求转发
				//req.getRequestDispatcher("user/stu/showcourse.jsp").forward(req, resp);
				resp.sendRedirect("user/stu/showcourse.jsp");
				return;
			}
		
	}
	//显示所有的学生信息
	private void showAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<Student> students=us.showAllStudent();
			HttpSession hs=req.getSession();
			//判断
			if(students!=null){
				//将查询的用户数据存储到request对象
				hs.setAttribute("students",students);
				resp.sendRedirect("user/tea/showstudent.jsp");
				return;
			}

	}
	//显示所有的教师信息
	private void showAllTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<Teacher> teachers=us.showAllTeacherWithCourse();
			HttpSession hs=req.getSession();
			//判断
			if(teachers!=null){
				//将查询的用户数据存储到request对象
				hs.setAttribute("teachers",teachers);
				resp.sendRedirect("user/admin/showteainfo.jsp");
				return;
			}

	}

	//更改学生信息
	private void chStuInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
		HttpSession hs=req.getSession();
		Student student = (Student) hs.getAttribute("user");
		String newname = req.getParameter("newname");
		String newsex = req.getParameter("newsex");
		String newtel = req.getParameter("newtel");
		String newaddress = req.getParameter("newaddress");
		String b =  req.getParameter("newbirthday");
		Date newbirthday = null;
		if(newname.equals("") ){
				newname = student.getSname();
		}if(newsex.equals("")){
			newsex=student.getSsex();
		}if(newtel.equals("")){
			newtel=student.getStel();
		}if(newaddress.equals("")){
			newaddress=student.getSaddress();
		}
		if(b.equals("")){
			newbirthday = student.getSbirthday();
		}else{
			newbirthday = new SimpleDateFormat("yyyy-MM-dd").parse(b);
		}
		//System.out.println(student.getSnum()+" " + newname + " " + newsex + " " + newtel + " " + newaddress + " " + newbirthday);
		int index = us.chStuInfo(student.getSnum(),newname,newsex,newtel,newaddress,newbirthday);
		if(index > 0){//更新成功
			Student s = us.getStu(student.getSnum());
			hs.setAttribute("user",s);
			resp.sendRedirect("user/stu/stuchInfo.jsp");
			return;
		}



	}

	//用户修改密码
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取数据
			String newPwd=req.getParameter("newpwd");
			//获取session对象
			HttpSession hs=req.getSession();
		//从session中获取用户信息
			String uid= (String) hs.getAttribute("uid");
		//处理请求
			//调用service处理
			int index=us.changePwd(uid,newPwd);
			if(index>0){
				hs.setAttribute("flag",2);
				//重定向到登录页面
				resp.sendRedirect("login.jsp");
			}
	}
	//用户退出
	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取session对象
		HttpSession hs=req.getSession();
		//强制销毁session
		hs.invalidate();
		//重定向到登录页面
		resp.sendRedirect("login.jsp");

	}

	//处理登录
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
				//获取请求信息
				String uname=req.getParameter("uname");
				String pwd=req.getParameter("pwd");
				//获取session对象
				HttpSession hs=req.getSession();
				//处理请求信息
					//校验
					Users u=us.checkUserLogin(uname,pwd);
					Student student = null;
					Teacher teacher = null;
					if(u!=null){
						System.out.println(u);
						hs.setAttribute("uid",u.getUid());

						int level = us.checkUserLevel(u);
						if(level == 1){//学生登录
							hs.setAttribute("level",1);
							student = us.getStu(u.getUid());
						}else if (level == 2){  //教师登录
							hs.setAttribute("level",2);
							teacher = us.getTeacher(u.getUid());
						}else if(level == 3){  //管理员登录
							hs.setAttribute("level",3);
						}


						if((int)hs.getAttribute("vcistrue") == 0){
							//将用户数据存储到session中
							if(level == 1){
								hs.setAttribute("user", student);
								//重定向
								resp.sendRedirect("main/studentmain/studentmain.jsp");
								return;
							}else if(level == 2){
								hs.setAttribute("user", teacher);
								//重定向
								resp.sendRedirect("main/teachermain/teachermain.jsp");
								return;
							}else{
								hs.setAttribute("user", u);
								//重定向
								resp.sendRedirect("main/adminmain/adminmain.jsp");
								return;
							}

						}else if((int)hs.getAttribute("vcistrue") == 1){
							//添加标识符到request中
							req.setAttribute("flag",1);
							//请求转发
							req.getRequestDispatcher("login.jsp").forward(req, resp);
							return;
						}
					}else{
						//添加标识符到request中
						req.setAttribute("flag",0);
						//请求转发
						req.getRequestDispatcher("login.jsp").forward(req, resp);
						return;
					}

					
	}



}
