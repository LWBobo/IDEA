package com.lwb.service.impl;

import com.lwb.dao.*;
import com.lwb.pojo.*;
import com.lwb.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    private InputStream in;
    private SqlSession sqlSession;
    private TeacherDao teadao;
    private StudentDao studao;
    private UsersDao usersdao;
    private CourseDao coursedao;
    private MsBoardDao msboarddao;

    public UserServiceImpl(){
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
        usersdao = sqlSession.getMapper(UsersDao.class);
        coursedao = sqlSession.getMapper(CourseDao.class);
        msboarddao = sqlSession.getMapper(MsBoardDao.class);
    }



    @Override
    public Users checkUserLogin(String uid, String upwd) {
        Users u = usersdao.findUser(uid,upwd);
        if(u != null){
            System.out.println(u);
            Student student = studao.findWithCourseById(u.getUid());
            Teacher teacher = teadao.findTeaNoWitnCourseById(u.getUid());
            if(student != null){
                u.setUname(student.getSname());
            }else if(teacher != null){
                u.setUname(teacher.getTname());
            }else{
                u.setUname(u.getUid());
            }

        }
        return u;
    }

    @Override
    public int checkUserLevel(Users users) {
        Student student = studao.findWithCourseById(users.getUid());
        Teacher teacher = teadao.findTeaNoWitnCourseById(users.getUid());
        if(student != null){
            return 1;
        }else if(teacher != null){
            return 2;
        }
        return 3;
    }

    @Override
    public Student getStu(String snum) {
        Student student = studao.findWithCourseAndGradeById(snum);
        return student;
    }

    @Override
    public Teacher getTeacher(String tnum) {
        Teacher teacher = teadao.findTeaWitnCourseById(tnum);
        return teacher;
    }

    @Override
    public String getpwd(String unum) {
       return usersdao.getpwd(unum);
    }

    @Override
    public int changePwd(String uid,String newpwd) {
       return usersdao.changePwd(uid,newpwd);
    }

    @Override
    public List<Course> showAllCourse() {
       return coursedao.findAllCourseWithTea();
    }

    @Override
    public int chStuInfo(String snum, String newname, String newsex, String newtel, String newaddress, Date newbirthday) {
       return studao.ChStuInfo(snum,newname,newsex,newtel,newaddress,newbirthday);
    }

    @Override
    public List<Student> showAllStudent() {
        return studao.findAllWithCourseAndTeaAndGrade();
    }

    @Override
    public List<Teacher> showAllTeacherWithCourse() {
        return teadao.findAllTeaWitnCourse();
    }

    @Override
    public int updateStuInfo(Student student) {
        return studao.updateStuInfo(student);
    }

    @Override
    public int updateTeaInfo(Teacher teacher) {
        return teadao.updateTeaInfo(teacher);
    }

    @Override
    public int updateCourseInfo(Course course) {
        return coursedao.updateCourseInfo(course);
    }

    @Override
    public List<MsBoard> showAllMessage() {
        return msboarddao.showAllMessage();
    }
}
