package com.lwb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lwb.pojo.MsBoard;
import org.apache.log4j.Logger;

import com.lwb.pojo.User;
import com.lwb.service.UserService;
import com.lwb.service.impl.UserServiceImpl;
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
	UserService us=new UserServiceImpl();

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
		}else if("out".equals(oper)){
			//调用退出功能
			userOut(req,resp);
		}else if("pwd".equals(oper)){
			//调用密码修改功能
			userChangePwd(req,resp);	
		}else if("show".equals(oper)){
			//调用显示所有用户功能
			userShow(req,resp);
		}else if("reg".equals(oper)){
			//调用注册功能
			userReg(req,resp);
		}else if("board".equals(oper)){
			//调用留言功能
			addUserMsBoard(req,resp);
		}else if("showboard".equals(oper)){
			//调用显示留言板功能
			broderShow(req,resp);
		}else{
			logger.debug("没有找到对应的操作符："+oper);
		}
	}
	//注册用户
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取请求信息
			String uname=req.getParameter("uname");
			String pwd=req.getParameter("pwd");
			String sex=req.getParameter("sex");
			int age=req.getParameter("age")!=""?Integer.parseInt(req.getParameter("age")):0;
			String birth=req.getParameter("birth");
			String[] bs=null;
			if(birth!=""){
				bs=birth.split("/");
				birth=bs[2]+"-"+bs[0]+"-"+bs[1];
			}
			System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
			User u=new User(0, uname, pwd, sex, age, birth);
		//处理请求信息
			//调用业务层处理
			int index=us.userRegService(u);
		//响应处理结果
			if(index>0){
				//获取session
				HttpSession hs=req.getSession();
				hs.setAttribute("flag", 3);
				//重定向
				resp.sendRedirect("login.jsp");
			}
		
	}
	//显示所有的用户信息
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//处理请求
			//调用service
			List<User> lu=us.userShowService();
			//判断
			if(lu!=null){
				//将查询的用户数据存储到request对象
				req.setAttribute("lu",lu);
				//请求转发
				req.getRequestDispatcher("user/showuser.jsp").forward(req, resp);
				return;
			}
		
	}
	//用户修改密码
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取数据
			String newPwd=req.getParameter("newpwd");
			//从session中获取用户信息
			User u=(User)req.getSession().getAttribute("user");
			int uid=u.getUid();
		//处理请求
			//调用service处理
			int index=us.userChangePwdService(newPwd,uid);
			if(index>0){
				//获取session对象
				HttpSession hs=req.getSession();
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
				//处理请求信息
					//校验
					User u=us.checkUserLoginService(uname, pwd);
					if(u!=null){
						//获取session对象
						HttpSession hs=req.getSession();
						if((int)hs.getAttribute("vcistrue") == 0){
							//将用户数据存储到session中
							hs.setAttribute("user", u);
							//重定向
							resp.sendRedirect("main/main.jsp");
							return;
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
	//处理留言板信息
	private  void addUserMsBoard(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String title = req.getParameter("mstitle");
		String keyword = req.getParameter("mskeyword");
		String info = req.getParameter("msinfo");

		if(title.equals("") || keyword.equals("") || info.equals("")){

		}else{
			//获取session对象
			HttpSession hs=req.getSession();
			User u = (User) hs.getAttribute("user");
			MsBoard ms = new MsBoard();
			ms.setUid(u.getUid());
			ms.setUname(u.getUname());
			ms.setMstitle(title);
			ms.setMskeyword(keyword);
			ms.setMsinfo(info);
			if(us.addUserMsBoardService(ms) >0){  //插入成功
					resp.sendRedirect("main/main.jsp");
					return;
			}

		}


	}

	private void broderShow(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		List<MsBoard> lm = us.userShowMsBoard();
		if(lm!=null){
			//将查询的用户数据存储到request对象
			req.setAttribute("lm",lm);
			//请求转发
			req.getRequestDispatcher("user/showmsboard.jsp").forward(req, resp);
			return;
		}



	}


	
}