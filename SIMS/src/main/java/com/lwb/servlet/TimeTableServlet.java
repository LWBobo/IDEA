package com.lwb.servlet;

import com.lwb.pojo.*;
import com.lwb.service.ScheduleService;
import com.lwb.service.UserService;
import com.lwb.service.impl.ScheduleServiceImpl;
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
    ScheduleService ss = new ScheduleServiceImpl();
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
        }else if(oper.equals("showcoursewithlabcourse")){
            showAllCourseWithLabCourse(req,resp);
        }else if(oper.equals("addlabcourse")){
            addLabCourse(req,resp);
        }else if(oper.equals("addlabsinfo")){
            addLabCourseinfo(req,resp);
        }else if(oper.equals("dellabcourse")){
            delLabCourse(req,resp);
        }else if(oper.equals("showadmintable")){
            showAdminTable(req,resp);
        }else{
            System.out.println("未找到操作符:" + oper);
        }
    }

    private void showStuTable(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession hs = req.getSession();
        String uid = (String) hs.getAttribute("userid");
        List<List<String>> table = ss.getStuTable(uid);
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
 private void showAdminTable(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession hs = req.getSession();
        String uid = (String) hs.getAttribute("userid");
        int index = ss.initadminTimeTable(uid);
        if(index == 1){

            List<List<String>> table = ss.getStuTable(uid);
            if(null != table){
                hs.setAttribute("admintable",table);
                try {
                    resp.sendRedirect("user/admin/showadmintable.jsp");
                    logger.debug("管理员查看课表");
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showAllCourseWithLabCourse(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession hs = req.getSession();
        List<Course> courses = ss.findAllCourseWithLabCourse();
        if(courses != null){
            hs.setAttribute("coursewithlabcourse",courses);
            try {
                resp.sendRedirect("user/admin/showcoursewithlabcourse.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void addLabCourse(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession hs = req.getSession();
        String uid = (String) hs.getAttribute("userid");
        Course course = new Course();
        course.setCnum(req.getParameter("cnum"));
        course.setCname(req.getParameter("cname"));

        /** 获取课程表*/
        List<List<String>> table = ss.getStuTable(uid);
        List<Lab> labs = ss.findAllLab();
        List<Course> courses = ss.findAllCourseWithLabCourse();
        if(table != null){
            hs.setAttribute("addlabcoursetabletemp",table);
        }if(labs != null){
            hs.setAttribute("alllab",labs);
        }if(courses != null){
            hs.setAttribute("coursewithlabcourse",courses);
        }

        hs.setAttribute("labcourseinfo",course);
        try {
            resp.sendRedirect("user/admin/addlabcoursedetal.jsp");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


 private void delLabCourse(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession hs = req.getSession();
        String uid = (String) hs.getAttribute("userid");
        String cnum = req.getParameter("cnum");



        int index = ss.delLabCourseFromTable(cnum,uid);
        if(index == 1){  //若执行成功
            List<List<String>> table = ss.getStuTable(uid);
            List<Course> courses = ss.findAllCourseWithLabCourse();
            if(null != table){
                hs.setAttribute("admintable",table);
                if(null != courses){
                    hs.setAttribute("coursewithlabcourse",courses);

                }
                try {
                    resp.sendRedirect("user/admin/showadmintable.jsp");
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }




    }

    private void addLabCourseinfo(HttpServletRequest req, HttpServletResponse resp) {
        String [] choices = req.getParameterValues("classchoice");
        HttpSession hs = req.getSession();
        LabClassSchedule labClassSchedule = new LabClassSchedule();
        LabCourse labCourse = new LabCourse();
        Course course = new Course();

        String labccnum = req.getParameter("labccnum");         //对应课程号
        String labccname = req.getParameter("labccname");        //对应课程名
        String labcname = req.getParameter("labcname");         //实验名称
        String labroom = req.getParameter("labroom");

        course.setCnum(labccnum);
        course.setCislabcourse(1);
   //     System.out.println(course);
  //      System.out.println("setCislabcourse:" + course.getCislabcourse());


        labCourse.setLcnum(labccnum+"X");
        labCourse.setLcname(labcname);
        labCourse.setLcccname(labccname);
        labCourse.setLcccnum(labccnum);
        labCourse.setLcclassroomnumber(labroom);


    //    System.out.println(labCourse);

        labClassSchedule.setLcnum(labccnum+"X");
        labClassSchedule.setLcname(labcname);

        int monday=0;int tuesday=0;int wednesday = 0;int thursday = 0;int friday = 0;
        for(String s :choices){
     //       System.out.println(s);
            String []s1 = s.split("-");
    //        System.out.println("周" + s1[1] + "第" + s1[0]+ "节");
            if(s1[1].equals("1")){
                int num = power(2,Integer.parseInt(s1[0])-1);
                monday += num;
            }else if(s1[1].equals("2")){
                int num = power(2,Integer.parseInt(s1[0])-1);
                tuesday += num;

            }else if(s1[1].equals("3")){
                int num = power(2,Integer.parseInt(s1[0])-1);
                wednesday += num;

            }else if(s1[1].equals("4")){
                int num = power(2,Integer.parseInt(s1[0])-1);
                thursday += num;

            }else if(s1[1].equals("5")){
                int num = power(2,Integer.parseInt(s1[0])-1);
                friday += num;

            }
        }
        labClassSchedule.setMonday(monday);
        labClassSchedule.setTuesday(tuesday);
        labClassSchedule.setWednesday(wednesday);
        labClassSchedule.setThursday(thursday);
        labClassSchedule.setFriday(friday);
  //      System.out.println(labClassSchedule);
        int index = ss.addLabScheduleAndUpdateTimetable(course,labCourse,labClassSchedule);
        if(index == 1){//添加实验课程成功

            String uid = (String) hs.getAttribute("userid");
            int index1 = ss.initadminTimeTable(uid);
            if(index1 == 1){

                List<List<String>> table = ss.getStuTable(uid);
                if(null != table){
                    hs.setAttribute("admintable",table);
                    try {
                        resp.sendRedirect("user/admin/showadmintable.jsp");
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }



    }


    /**
     * 进行一个次方的运算，处理数据
     * @param a
     * @param b
     * @return
     */
    public static int power(int a , int b) {
        int power = 1;
        for (int c = 0; c < b; c++)
            power *= a;
        return power;
    }




}
