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
import java.util.ArrayList;
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
    private LabCourseDao labcoursedao;

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
        labcoursedao = sqlSession.getMapper(LabCourseDao.class);
    }


    /**
     * 将实验课程安排表转化为课表
     * @param labClassSchedule
     * @param uid
     * @return
     */
    @Override
    public TimeTable doLabScheduleToTimetable(LabClassSchedule labClassSchedule, String uid ,TimeTable timetable) {
        LabCourse labCourse = labcoursedao.findLabCourseByLcnum(labClassSchedule.getLcnum());

        if(labClassSchedule.getMonday() != 0){
            String str1 = ClassUtil.decimalToBinary(labClassSchedule.getMonday());
     //       System.out.println("转换后的字符串:"+str1);
            for(int i = str1.length()-1,k=1 ; i >=0 ; i--,k++){
                if(str1.charAt(i) == '1'){  //该课程被安排在这一节

                        Object obj = doget(timetable,"getMonday" + k);
                        if(obj == null){
                            doset(timetable,"setMonday" + k,labClassSchedule.getLcname() + "-"+labCourse.getLcclassroomnumber());


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
                        doset(timetable,"setTuesday" + k,labClassSchedule.getLcname()+ "-"+labCourse.getLcclassroomnumber());


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
                        doset(timetable,"setWednesday" + k,labClassSchedule.getLcname()+ "-"+labCourse.getLcclassroomnumber());


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
                        doset(timetable,"setThursday" + k,labClassSchedule.getLcname()+ "-"+labCourse.getLcclassroomnumber());


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
                        doset(timetable,"setFriday" + k,labClassSchedule.getLcname()+ "-"+labCourse.getLcclassroomnumber());


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

//            System.out.println(s);
//            System.out.println(timeTable);


        }

    }

    @Override
    public int initadminTimeTable(String uid) {
        List<ClassSchedule> schedules = classscheduledao.findAll();


            TimeTable timeTable = tabledao.findTableById(uid);
            TimeTable tablecopy = tabledao.findTableById(uid);   //一份备用  避免删除后出现错误造成课表丢失
            tabledao.delTimeTable(uid);   //将存在的课表删除

        List<Course> courses = us.showAllCourse();
        TimeTable table = new TimeTable();
        table.setTableid(uid);
        for (Course c : courses){
            for(ClassSchedule classschedule : schedules){
                if(c.getCnum().equals(classschedule.getCnum())){ //如果选课程与课程排课表匹配,将更新课表
                    TimeTable timeTable1temp = doScheduleToTimetable(classschedule,uid,table);
                    if(timeTable1temp != null ){
                        table = timeTable1temp;
                    }else{
                        tabledao.insertTimeTable(tablecopy);  //如果发生异常,执行返回操作
                        return -1;
                    }
                    if(c.getCislabcourse() == 1){  //如果该课程拥有实验课
                        LabClassSchedule labClassSchedule = labclasssdao.findScheduleByLcnum(c.getCnum() + "X");
                        TimeTable tabletemp = doLabScheduleToTimetable(labClassSchedule,uid,table);
                        if(tabletemp != null){//如果实验课程没有冲突,成功排课
                            table = tabletemp;

                        }else{
                            tabledao.insertTimeTable(tablecopy);    //如果发生异常,执行返回操作
                            return -1;
                        }
                    }

                }
            }
        }
        timeTable = table;



        int index2 = tabledao.insertTimeTable(timeTable);
        if(index2 == 1){
            System.out.println("插入成功!!");
            return 1;
        }


    return 0;
    }

    @Override
    public int initAllTeaTable() {
       List<Teacher> teachers = us.showAllTeacherWithCourse();
        List<ClassSchedule> schedules = classscheduledao.findAll();
       for(Teacher t : teachers){
           List<Course> courses = t.getCourses();
           String uid = t.getTnum();
           TimeTable timetable = tabledao.findTableById(uid);
           TimeTable tablecopy = tabledao.findTableById(uid);   //一份备用  避免删除后出现错误造成课表丢失
           if(timetable != null){  //已经存在该教师的课表
               tabledao.delTimeTable(t.getTnum());   //将存在的课表删除
           }else{  //不存在该教师的课表
               TimeTable table = new TimeTable();
               table.setTableid(t.getTnum());

               for(Course c : courses){
                   for(ClassSchedule classschedule : schedules){
                       if(c.getCnum().equals(classschedule.getCnum())){ //如果选课程与课程排课表匹配,将更新课表
                           TimeTable timeTable1temp = doScheduleToTimetable(classschedule,uid,table);
                           if(timeTable1temp != null ){
                               table = timeTable1temp;
                           }else{
                               tabledao.insertTimeTable(tablecopy);  //如果发生异常,执行返回操作
                               return -1;
                           }
                           if(c.getCislabcourse() == 1){  //如果该课程拥有实验课
                               LabClassSchedule labClassSchedule = labclasssdao.findScheduleByLcnum(c.getCnum() + "X");
                               TimeTable tabletemp = doLabScheduleToTimetable(labClassSchedule,uid,table);
                               if(tabletemp != null){//如果实验课程没有冲突,成功排课
                                   table = tabletemp;

                               }else{
                                   tabledao.insertTimeTable(tablecopy);    //如果发生异常,执行返回操作
                                   return -1;
                               }
                           }

                       }
                   }
               }

               timetable = table;

           }


           int index = tabledao.insertTimeTable(timetable);
           if(index == 1){
               System.out.println("插入成功!!");
           }

       }




        return 1;
    }

    @Override
    public int initTeaTable(String teanum) {
        String uid = teanum;
        List<ClassSchedule> schedules = classscheduledao.findAll();
        Teacher teacher = us.getTeacher(uid);


        TimeTable timeTable = tabledao.findTableById(uid);
        TimeTable tablecopy = tabledao.findTableById(uid);   //一份备用  避免删除后出现错误造成课表丢失
        tabledao.delTimeTable(uid);   //将存在的课表删除

        List<Course> courses = teacher.getCourses();
        TimeTable table = new TimeTable();
        table.setTableid(uid);
        for (Course c : courses){
            for(ClassSchedule classschedule : schedules){
                if(c.getCnum().equals(classschedule.getCnum())){ //如果选课程与课程排课表匹配,将更新课表
                    TimeTable timeTable1temp = doScheduleToTimetable(classschedule,uid,table);
                    if(timeTable1temp != null ){
                        table = timeTable1temp;
                    }else{
                        tabledao.insertTimeTable(tablecopy);  //如果发生异常,执行返回操作
                        return -1;
                    }
                    if(c.getCislabcourse() == 1){  //如果该课程拥有实验课
                        LabClassSchedule labClassSchedule = labclasssdao.findScheduleByLcnum(c.getCnum() + "X");
                        TimeTable tabletemp = doLabScheduleToTimetable(labClassSchedule,uid,table);
                        if(tabletemp != null){//如果实验课程没有冲突,成功排课
                            table = tabletemp;

                        }else{
                            tabledao.insertTimeTable(tablecopy);    //如果发生异常,执行返回操作
                            return -1;
                        }
                    }

                }
            }
        }
        timeTable = table;



        int index2 = tabledao.insertTimeTable(timeTable);
        if(index2 == 1){
            System.out.println("插入成功!!");
            return 1;
        }


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


    @Override
    public List<List<String>> getStuTable(String tableid) {
    //    System.out.println( "impl: "+tableid);
        TimeTable timetable = tabledao.findTableById(tableid);
        List<List<String>> table = timetable.getTable();
        return table;
    }

    @Override
    public int insertLabCourse(LabCourse labCourse) {
        return labcoursedao.insertLabCourse(labCourse);
    }

    @Override
    public int insertLabClassSchedule(LabClassSchedule labClassSchedule) {
        return labclasssdao.addLabClassSchedule(labClassSchedule);
    }

    @Override
    public int delLabCourse(String lcnum) {
        return labcoursedao.delLabCourse(lcnum);
    }

    @Override
    public int delLabClassSchedule(String lcnum) {
        return labclasssdao.delLabClassSchedule(lcnum);
    }

    @Override
    public int delLabCourseFromTable(String cnum ,String adminNum) {

        String lcnum = cnum +"X";
        Course course = new Course();
        course.setCnum(cnum);
        course.setCislabcourse(0);

        int index1 = delLabClassSchedule(lcnum);   //先删除实验课安排表
        int index2 = delLabCourse(lcnum);        //再删除实验课程表
        int index3 = us.updateCourseInfo(course);       //将课程的是否有实验课字段置为0

        if(index1 ==1 && index2 == 1 && index3 == 1){   //操作执行成功
            try {
                initTimeTable();
            } catch (ClassRepeatException e) {
                e.printStackTrace();
                System.err.println("课程存在冲突");
                return 0;
            }
            int index4 = initadminTimeTable(adminNum);
            int index5 = initAllTeaTable();
           if(index4 == 1 && index5 == 1){
               return 1;
           }
           return 0;

        }else{
            sqlSession.rollback();
            return 0;
        }


    }

    @Override
    public int addLabScheduleAndUpdateTimetable(Course course, LabCourse labCourse, LabClassSchedule labClassSchedule) {
        int courseindex = us.updateCourseInfo(course);
        int labcourseindex = insertLabCourse(labCourse);
        int labclassscheduleindex = insertLabClassSchedule(labClassSchedule);

        if(courseindex == 1 && labcourseindex == 1 && labclassscheduleindex == 1){ //如果三个值都插入成功
            try {
                initTimeTable();
            } catch (ClassRepeatException e) {
                e.printStackTrace();
                return -1;
            }
            return 1;

        }else{
            sqlSession.rollback();  // 如果出现异常,进行回滚
            return -1;
        }


    }

    @Override
    public String getTeaCname(String teanum) {
        Teacher teacher = us.getTeacher(teanum);
        List<Course> teacourse = teacher.getCourses();
       StringBuffer teacname = new StringBuffer();
        List<ClassSchedule> classSchedules = classscheduledao.findAll();   //普通课程安排表
        for(Course c : teacourse){
            for(ClassSchedule c1 : classSchedules){
                if(c.getCnum().equals(c1.getCnum())){//纪录下教师所教课程编号
                    teacname.append(c1.getCname()+"-" + c1.getClassroomnum() + " ");
                    if(c.getCislabcourse() == 1){
                        LabCourse labCourse = labcoursedao.findLabCourseByCnum(c.getCnum());  //实验课程安排表
                        teacname.append(labCourse.getLcname()+"-"+labCourse.getLcclassroomnumber() + " ");
                    }
                }
            }
        }

        return teacname.toString();


    }

}
