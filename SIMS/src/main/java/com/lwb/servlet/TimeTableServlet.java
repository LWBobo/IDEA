package com.lwb.servlet;

import com.lwb.pojo.TimeTable;
import com.lwb.service.UserService;
import com.lwb.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TimeTableServlet", urlPatterns = "/table")
public class TimeTableServlet extends HttpServlet {
    UserService us = new UserServiceImpl();
    Logger logger =Logger.getLogger(TimeTableServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");


        String oper=req.getParameter("oper");
        if(oper.equals("showstutable")){
            showStuTable(req,resp);
        }
    }

    private void showStuTable(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession hs = req.getSession();
        String tableid = req.getParameter("tableid");
        List<List<String>> table = us.getStuTable(Integer.parseInt(tableid));
       if(null != table){
           hs.setAttribute("stutable",table);
           try {
               resp.sendRedirect("user/stu/showstutable.jsp");
               logger.debug("学生用户查看课表");
               return;
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }





}
