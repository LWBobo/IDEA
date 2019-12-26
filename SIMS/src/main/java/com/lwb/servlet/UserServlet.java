package com.lwb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.*;

import com.lwb.pojo.*;
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
			//调用显示所有教师信息功能
			showAllTeacher(req,resp);
		}else if("teachteainfo".equals(oper)){
			//调用教师修改自己信息
			teaUpdateTeaInfo(req,resp);
		}else if("teachcourseinfo".equals(oper)){
			//调用教师修改自己所教授课程信息
			teaUpdateCourseInfo(req,resp);
		}else if("adminchangecourseinfo".equals(oper)){
			//调用管理员修改课程信息
			adminUpdateCourseInfo(req,resp);
		}else if("adminupdateteainfo".equals(oper)){
			//调用管理员修改教师信息
			adminUpdateTeaInfo(req,resp);
		}else if("adminupdatestuinfo".equals(oper)){
			//调用管理员修改学生信息
			adminUpdateStuInfo(req,resp);
		}else if("showallmessage".equals(oper)){
			//调用显示所有留言信息
			showAllMessage(req,resp);
		}else if("addmessage".equals(oper)){
			//调用显示所有留言信息
			addMessage(req,resp);
		}else if("delmessage".equals(oper)){
			//调用显示所有留言信息
			delMessage(req,resp);
		}else if("updatemessage".equals(oper)){
			//调用显示所有留言信息
			updateMessage(req,resp);
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

						/**
						 * 获取用户本人的留言信息
						 */
						List<MsBoard> myboard = us.showMyBoard(u.getUid());
						hs.setAttribute("myboard",myboard);

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
								hs.setAttribute("userid",student.getSnum());
								hs.setAttribute("username",student.getSname());
								//重定向
								resp.sendRedirect("main/studentmain/studentmain.jsp");
								return;
							}else if(level == 2){
								hs.setAttribute("user", teacher);
								hs.setAttribute("userid",teacher.getTnum());
								hs.setAttribute("username",teacher.getTname());
								//重定向
								resp.sendRedirect("main/teachermain/teachermain.jsp");
								return;
							}else{
								hs.setAttribute("user", u);
								hs.setAttribute("userid",u.getUid());
								hs.setAttribute("username",u.getUname());
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


	private void teaUpdateTeaInfo(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		Teacher teacher = new Teacher();
		String tnum = req.getParameter("tnum");
		teacher.setTnum(tnum);
		String newtname = req.getParameter("newtname");
		String newtsex = req.getParameter("newtsex");
		String birthday = req.getParameter("newbirthday");
		Date newbirthday = null;
		if(!newtname.equals("")){//若姓名不为空
			teacher.setTname(newtname);
		}if(!newtsex.equals("")){
			teacher.setTsex(newtsex);
		}if(!birthday.equals("")){
			try {
				newbirthday =new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				teacher.setTbirthday(newbirthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		int index = us.updateTeaInfo(teacher);
		if(index == 1){//更新成功
			Teacher teacher1 =us.getTeacher(tnum);
			//及时更新教师信息
			if(teacher1 != null){
				//将查询的用户数据存储到request对象
				hs.setAttribute("user",teacher1);

			}


				//进行请求转发
			try {
				resp.sendRedirect("user/tea/teachinfo.jsp");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

private void teaUpdateCourseInfo(HttpServletRequest req, HttpServletResponse resp) {
	HttpSession hs = req.getSession();
	Course course = new Course();
	String cnum = req.getParameter("cnum");
	String tnum = req.getParameter("tnum");
	String newcname = req.getParameter("newcname");
	String credit = req.getParameter("newccredit");
	String cbegintime = req.getParameter("newcbegintime");
	String cendtime = req.getParameter("newcendtime");
	course.setCnum(cnum);
	Date time = null;
	if(!newcname.equals("")){
		course.setCname(newcname);
	}if(!credit.equals("")){
		int newcredit = Integer.parseInt(credit);
		course.setCcredit(newcredit);
	}if(!cbegintime.equals("")){
		try {
			time = new SimpleDateFormat("yyyy-MM-dd").parse(cbegintime);
			course.setCbegintime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}if(!cendtime.equals("")){
		try {
			time = new SimpleDateFormat("yyyy-MM-dd").parse(cendtime);
			course.setCendtime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	int index = us.updateCourseInfo(course);
	if(index == 1){//更新成功
		//及时更新课程信息
		List<Course> lu=us.showAllCourse();
		Teacher teacher = us.getTeacher(tnum);
		//判断
		if(lu!=null && teacher != null){
			//将查询的用户数据存储到request对象
			hs.setAttribute("lu",lu);
			hs.setAttribute("user",teacher);

			try {
				resp.sendRedirect("user/tea/teachinfo.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}


	}

private void adminUpdateCourseInfo(HttpServletRequest req, HttpServletResponse resp) {
	HttpSession hs = req.getSession();
	Course course = new Course();
	String cnum = req.getParameter("cnum");
	String newcname = req.getParameter("newcname");
	String credit = req.getParameter("newccredit");
	String cbegintime = req.getParameter("newcbegintime");
	String cendtime = req.getParameter("newcendtime");
	course.setCnum(cnum);
	Date time = null;
	if(!newcname.equals("")){
		course.setCname(newcname);
	}if(!credit.equals("")){
		int newcredit = Integer.parseInt(credit);
		course.setCcredit(newcredit);
	}if(!cbegintime.equals("")){
		try {
			time = new SimpleDateFormat("yyyy-MM-dd").parse(cbegintime);
			course.setCbegintime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}if(!cendtime.equals("")){
		try {
			time = new SimpleDateFormat("yyyy-MM-dd").parse(cendtime);
			course.setCendtime(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	int index = us.updateCourseInfo(course);
	if(index == 1){//更新成功
		//及时更新课程信息
		List<Course> lu=us.showAllCourse();
		//判断
		if(lu!=null ){
			//将查询的用户数据存储到request对象
			hs.setAttribute("lu",lu);

			try {
				resp.sendRedirect("user/admin/changecourseinfo.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}


	}

	private void adminUpdateTeaInfo(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		Teacher teacher = new Teacher();
		String tnum = req.getParameter("tnum");
		teacher.setTnum(tnum);
		String newtname = req.getParameter("newtname");
		String newtsex = req.getParameter("newtsex");
		String newttitle = req.getParameter("newttitle");
		String birthday = req.getParameter("newtbirthday");
		Date newbirthday = null;
		if(!newtname.equals("")){//若姓名不为空
			teacher.setTname(newtname);
		}if(!newtsex.equals("")){
			teacher.setTsex(newtsex);
		}if(!newttitle.equals("")){
			teacher.setTtitle(newttitle);
		}if(!birthday.equals("")){
			try {
				newbirthday =new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				teacher.setTbirthday(newbirthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		int index = us.updateTeaInfo(teacher);
		if(index == 1){//更新成功
			List<Teacher> teachers=us.showAllTeacherWithCourse();
			//判断
			if(teachers!=null){
				//将查询的用户数据存储到request对象
				hs.setAttribute("teachers",teachers);
				try {
					resp.sendRedirect("user/admin/changeteainfo.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}

		}

	}

	private void adminUpdateStuInfo(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		Student student = new Student();
		String snum = req.getParameter("snum");
		student.setSnum(snum);
		String newsname = req.getParameter("newsname");
		String newssex = req.getParameter("newssex");
		String newstel = req.getParameter("newstel");
		String newsaddress = req.getParameter("newsaddress");
		String birthday = req.getParameter("newsbirthday");
		Date newsbirthday = null;
		if(!newsname.equals("")){
			student.setSname(newsname);

		}if(!newssex.equals("")){

			student.setSsex(newssex);
		}if(!newstel.equals("")){

			student.setStel(newstel);
		}if(!newsaddress.equals("")){

			student.setSaddress(newsaddress);
		}if(!birthday.equals("")){
			try {
				newsbirthday =new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				student.setSbirthday(newsbirthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		int index = us.updateStuInfo(student);
		if(index == 1){
			List<Student> students=us.showAllStudent();
			//判断
			if(students!=null){
				//将查询的用户数据存储到request对象
				hs.setAttribute("students",students);
				try {
					resp.sendRedirect("user/admin/changestuinfo.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}

		}


	}

	private void showAllMessage(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		List<MsBoard> msboards = us.showAllMessage();
		if(msboards != null){
			hs.setAttribute("lm",msboards);

			try {
				resp.sendRedirect("user/showmsboard.jsp");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	private void addMessage(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		MsBoard msboard = new MsBoard();
		String userid = req.getParameter("userid");
		String username = req.getParameter("username");
		msboard.setUid(userid);
		msboard.setUname(username);
		String mstitle = req.getParameter("mstitle");
		String mskeyword = req.getParameter("mskeyword");
		String mscontents = req.getParameter("mscontents");
		if(!mstitle.equals("")){
			msboard.setMstitle(mstitle);
		}if(!mskeyword.equals("")){
			msboard.setMskeyword(mskeyword);
		}if(!mscontents.equals("")){
			msboard.setMscontents(mscontents);
		}
		int index = us.addMessage(msboard);
		if(index == 1){
			/**
			 * 更新个人留言板
			 */
			List<MsBoard> myboard = us.showMyBoard((String) hs.getAttribute("userid"));
			hs.setAttribute("myboard",myboard);
            try {
                resp.sendRedirect("user/showmymsboard.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }

		}

	}
private void delMessage(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		String msid = req.getParameter("msid");
		int index =us.delmessage(Integer.parseInt(msid));
		if(index == 1){
			/**
			 * 更新个人留言板
			 */
			List<MsBoard> myboard = us.showMyBoard((String) hs.getAttribute("userid"));
			hs.setAttribute("myboard",myboard);
            try {
                resp.sendRedirect("user/showmymsboard.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }

		}

	}
private void updateMessage(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession hs = req.getSession();
		MsBoard msboard = new MsBoard();
		String msid = req.getParameter("msid");
		msboard.setMsid(Integer.parseInt(msid));
		String mstitle = req.getParameter("mstitle");
		String mskeyword = req.getParameter("mskeyword");
		String mscontents = req.getParameter("mscontents");
        if(!mstitle.equals("")){
            msboard.setMstitle(mstitle);
        }if(!mskeyword.equals("")){
            msboard.setMskeyword(mskeyword);
        }if(!mscontents.equals("")){
            msboard.setMscontents(mscontents);
        }
        int index = us.updateMessage(msboard);
        if(index == 1){
            /**
             * 更新个人留言板
             */
            List<MsBoard> myboard = us.showMyBoard((String) hs.getAttribute("userid"));
            hs.setAttribute("myboard",myboard);
            try {
                resp.sendRedirect("user/showmymsboard.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


	}


}
