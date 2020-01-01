package com.lwb.service.impl;

import com.lwb.dao.*;
import com.lwb.pojo.*;
import com.lwb.service.ScheduleService;
import com.lwb.service.UserService;
import com.lwb.util.ClassUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {

    private InputStream in;
    private SqlSession sqlSession;
    private CourseDao coursedao;
    private TimeTableDao tabledao;
    private LabClassScheduleDao labclasssdao;
    private LabDao labdao;
    private UserService us;
    private ClassScheduleDao classscheduledao;

    public ScheduleServiceImpl(){
        //1.读取配置文件，生成字节输入流
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        coursedao = sqlSession.getMapper(CourseDao.class);
        tabledao = sqlSession.getMapper(TimeTableDao.class);
        labclasssdao = sqlSession.getMapper(LabClassScheduleDao.class);
        labdao = sqlSession.getMapper(LabDao.class);
        classscheduledao = sqlSession.getMapper(ClassScheduleDao.class);
        us = new UserServiceImpl();
    }


    /**
     * 将实验课程安排表转化为课表
     * @param labClassSchedule
     * @param uid
     * @return
     */
    @Override
    public TimeTable doLabScheduleToTimetable(LabClassSchedule labClassSchedule, String uid ,TimeTable timetable) {

        if(labClassSchedule.getMonday() != 0){
            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getMonday());
     //       System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                        Object obj = doget(timetable,"getMonday" + k);
                        if(obj == null){
                            doset(timetable,"setMonday" + k,labClassSchedule.getLcname());


                        }else {   //如果这节课已经被安排过其他的课程
                            System.out.println("这节课已经被安排过啦"  + " 周一第" + k + "节:" + obj);
                            return null;
                        }


                }
            }

        }if(labClassSchedule.getTuesday() != 0){
            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getTuesday());
       //     System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getTuesday" + k);
                    if(obj == null){
                        doset(timetable,"setTuesday" + k,labClassSchedule.getLcname());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周二第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(labClassSchedule.getWednesday() != 0){
            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getWednesday());
      //      System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getWednesday" + k);
                    if(obj == null){
                        doset(timetable,"setWednesday" + k,labClassSchedule.getLcname());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周三第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(labClassSchedule.getThursday() != 0){
            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getThursday());
       //     System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getThursday" + k);
                    if(obj == null){
                        doset(timetable,"setThursday" + k,labClassSchedule.getLcname());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周四第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(labClassSchedule.getFriday() != 0){

            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getFriday());
       //     System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getFriday" + k);
                    if(obj == null){
                        doset(timetable,"setFriday" + k,labClassSchedule.getLcname());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周五第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }
//        System.out.println("更新后的课表:");
//        System.out.println(timetable);

        return timetable;
    }

    /**
     * 将课程安排表转化为课表
     * @param classSchedule
     * @param uid
     * @return
     */
    @Override
    public TimeTable doScheduleToTimetable(ClassSchedule classSchedule, String uid,TimeTable timetable) {

        if(classSchedule.getMonday() != 0){
            String str1 = ClassUtil.decimalToBinary(classSchedule.getMonday());
     //       System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getMonday" + k);
                    if(obj == null){
                        doset(timetable,"setMonday" + k,classSchedule.getCname() + "-" +classSchedule.getClassroomnum());  /** 课程名-教室编号 */


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周一第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(classSchedule.getTuesday() != 0){
            String str1 = ClassUtil.decimalToBinary(classSchedule.getTuesday());
      //      System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getTuesday" + k);
                    if(obj == null){
                        doset(timetable,"setTuesday" + k,classSchedule.getCname() + "-" +classSchedule.getClassroomnum());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周二第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(classSchedule.getWednesday() != 0){
            String str1 = ClassUtil.decimalToBinary(classSchedule.getWednesday());
     //       System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getWednesday" + k);
                    if(obj == null){
                        doset(timetable,"setWednesday" + k,classSchedule.getCname() + "-" +classSchedule.getClassroomnum());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周三第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(classSchedule.getThursday() != 0){
            String str1 = ClassUtil.decimalToBinary(classSchedule.getThursday());
    //        System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getThursday" + k);
                    if(obj == null){
                        doset(timetable,"setThursday" + k,classSchedule.getCname() + "-" +classSchedule.getClassroomnum());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周四第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }if(classSchedule.getFriday() != 0){

            String str1 = ClassUtil.decimalToBinary(classSchedule.getFriday());
      //      System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                    Object obj = doget(timetable,"getFriday" + k);
                    if(obj == null){
                        doset(timetable,"setFriday" + k,classSchedule.getCname() + "-" +classSchedule.getClassroomnum());


                    }else {   //如果这节课已经被安排过其他的课程
                        System.out.println("这节课已经被安排过啦"  + " 周五第" + k + "节:" + obj);
                        return null;
                    }


                }
            }

        }


   //     System.out.println("更新后的课表:");
   //     System.out.println(timetable);

        return timetable;
    }

    @Override
    public List<Course> findAllCourseWithLabCourse() {
        return coursedao.findAllCourseWithLabCourse();
    }

    @Override
    public List<Lab> findAllLab() {
        return labdao.findAllLab();
    }

    /**
     * 初始化每个学生的课表
     */
    @Override
    public void initTimeTable() throws ClassRepeatException{
        List<Student> students = us.showAllStudent();
        List<ClassSchedule> schedules = classscheduledao.findAll();


        for (Student s :students){  //遍历,初始化没个学生的信息
            TimeTable timeTable = tabledao.findTableById(s.getSnum());

            if(timeTable == null){  //数据库不存在该学生的课表
                List<Course> courses = s.getCourses();
                TimeTable table = new TimeTable();
                table.setTableid(s.getSnum());
                for (Course c : courses){
                    for(ClassSchedule classschedule : schedules){
                        if(c.getCnum().equals(classschedule.getCnum())){ //如果学生所选课程与课程排课表匹配,将更新课表
                            TimeTable timeTable1temp = doScheduleToTimetable(classschedule,s.getSnum(),table);
                            if(timeTable1temp != null ){
                                table = timeTable1temp;
                            }else{
                                throw new ClassRepeatException("课程冲突");
                            }
                            if(c.getCislabcourse() == 1){  //如果该课程拥有实验课
                                LabClassSchedule labClassSchedule = labclasssdao.findScheduleByLcnum(c.getCnum() + "X");
                                TimeTable tabletemp = doLabScheduleToTimetable(labClassSchedule,s.getSnum(),table);
                                if(tabletemp != null){//如果实验课程没有冲突,成功排课
                                    table = tabletemp;

                                }else{
                                    throw new ClassRepeatException("实验课冲突");
                                }
                            }

                        }
                    }
                }
                timeTable = table;

                /** 将信息插入数据库 */
                int index = tabledao.insertTimeTable(timeTable);
                if(index == 1){
                    System.out.println("插入成功!");
                }


            }else{  //该学生课表已经存在
                TimeTable tablecopy = tabledao.findTableById(s.getSnum());   //一份备用  避免删除后出现错误造成课表丢失
                int index = tabledao.delTimeTable(timeTable.getTableid());   //将存在的课表删除
                if(index == 1){   //如果删除成功
                List<Course> courses = s.getCourses();
                    TimeTable table = new TimeTable();
                    table.setTableid(s.getSnum());
                for (Course c : courses){
                    for(ClassSchedule classschedule : schedules){
                        if(c.getCnum().equals(classschedule.getCnum())){ //如果学生所选课程与课程排课表匹配,将更新课表
                            TimeTable timeTable1temp = doScheduleToTimetable(classschedule,s.getSnum(),table);
                            if(timeTable1temp != null ){
                                table = timeTable1temp;
                            }else{
                                tabledao.insertTimeTable(tablecopy);  //如果发生异常,执行返回操作
                                throw new ClassRepeatException("课程冲突");
                            }
                            if(c.getCislabcourse() == 1){  //如果该课程拥有实验课
                                LabClassSchedule labClassSchedule = labclasssdao.findScheduleByLcnum(c.getCnum() + "X");
                                TimeTable tabletemp = doLabScheduleToTimetable(labClassSchedule,s.getSnum(),table);
                                if(tabletemp != null){//如果实验课程没有冲突,成功排课
                                    table = tabletemp;

                                }else{
                                    tabledao.insertTimeTable(tablecopy);    //如果发生异常,执行返回操作
                                    throw new ClassRepeatException("实验课冲突");
                                }
                            }

                        }
                    }
                }
                timeTable = table;



                    int index2 = tabledao.insertTimeTable(timeTable);
                    if(index2 == 1){
                        System.out.println("插入成功!!");
                    }
                }

            }

            System.out.println(s);
            System.out.println(timeTable);


        }

    }


    /**
     * 使用反射动态获取课表信息
     * @param timeTable
     * @param methodName
     * @return
     */
    public Object doget(TimeTable timeTable ,String methodName){
        Class<?> clazz = null;    //反射对象声明


        try {
            clazz = Class.forName("com.lwb.pojo.TimeTable");
            Method method = clazz.getMethod(methodName);
            Object object = method.invoke(timeTable);
            return object;   //返回该列的对象信息

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }


    /**
     * 使用反射设置课表信息
     */
    public void doset(TimeTable timeTable,String methodName,String value){
        Class<?> clazz = null;    //反射对象声明
        try {
            clazz = Class.forName("com.lwb.pojo.TimeTable");
            Method method = clazz.getMethod(methodName,String.class);
            method.invoke(timeTable,value);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<List<String>> getStuTable(String tableid) {
        TimeTable timetable = tabledao.findTableById(tableid);
        List<List<String>> table = timetable.getTable();
        return table;
    }

}
