package com.lwb.servlet;

import com.lwb.pojo.Users;
import com.lwb.service.UserService;
import com.lwb.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");


        //获取操做符
        String oper=req.getParameter("oper");

        if(oper.equals("changepwd")){
            changepwd(req,resp);
        }
    }


















    private void changepwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession hs = req.getSession();
        String inpwd = req.getParameter("newpwd");
        String uid = (String) hs.getAttribute("uid");
        String realpwd = us.getpwd(uid);
        System.out.println("inpwd: " + inpwd);
        System.out.println("realpwd: " + realpwd);
        if(realpwd.equals(inpwd)){
            resp.getWriter().write("密码正确");
        }else {
            resp.getWriter().write("密码错误");
        }

    }




}
