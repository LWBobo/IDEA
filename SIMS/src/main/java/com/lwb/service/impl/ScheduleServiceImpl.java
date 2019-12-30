package com.lwb.service.impl;

import com.lwb.dao.*;
import com.lwb.pojo.LabClassSchedule;
import com.lwb.pojo.TimeTable;
import com.lwb.service.ScheduleService;
import com.lwb.util.ClassUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScheduleServiceImpl implements ScheduleService {

    private InputStream in;
    private SqlSession sqlSession;
    private TeacherDao teadao;
    private StudentDao studao;
    private CourseDao coursedao;
    private TimeTableDao tabledao;
    private LabClassScheduleDao labclasssdao;

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
        teadao = sqlSession.getMapper(TeacherDao.class);
        studao = sqlSession.getMapper(StudentDao.class);
        coursedao = sqlSession.getMapper(CourseDao.class);
        tabledao = sqlSession.getMapper(TimeTableDao.class);
        labclasssdao = sqlSession.getMapper(LabClassScheduleDao.class);
    }


    @Override
    public int doScheduleToTimetable(LabClassSchedule labClassSchedule) {
        TimeTable timetable = tabledao.findTableById(1);

        if(labClassSchedule.getMonday() != 0){
            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getMonday());
            System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                        Object obj = doget(timetable,"getMonday" + k);
                        if(obj == null){
                            doset(timetable,"setMonday" + k,labClassSchedule.getLcname());


                        }else {
                            System.out.println("这节课已经被安排过啦" + ":i=" + i + " k=" + k);
                        }


                }
            }

        }if(labClassSchedule.getTuesday() != 0){

        }if(labClassSchedule.getWednesday() != 0){

        }if(labClassSchedule.getThursday() != 0){

        }if(labClassSchedule.getFriday() != 0){

        }


        System.out.println("更新后的课表:");
        System.out.println(timetable);

        return 0;
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

}
