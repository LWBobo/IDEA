package com.lwb.service;

import com.lwb.pojo.Course;
import com.lwb.pojo.Student;
import com.lwb.pojo.Teacher;
import com.lwb.pojo.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.StringHolder;

import java.util.Date;
import java.util.List;

public interface UserService {
    /**
     * 用户登录
     * @param uid
     * @param upwd
     * @return
     */
    Users checkUserLogin(String uid,String upwd);

    /**
     * 监测用户等级:学生/老师/管理员
     * @param users
     * @return
     */
    int checkUserLevel(Users users);

    /**
     * 获取学生
     * @param snum
     * @return
     */
    Student getStu(String snum);

    /**
     *
     * @param tnum
     * @return
     */
    Teacher getTeacher(String tnum);


    /**
     * 获取密码
     * @param unum
     * @return
     */
    String getpwd(String unum);

    /**
     * 修改密码
     * @param uid
     * @return
     */
    int changePwd(String uid,String newpwd);

    /**
     * 显示所有课程信息
     * @return
     */
    List<Course> showAllCourse();

    /**
     * 更新学生信息
     * @param snum
     * @param newname
     * @param newsex
     * @param newtel
     * @param newaddress
     * @param newbirthday
     * @return
     */
    int chStuInfo( String snum,String newname,String newsex,String newtel,String newaddress,Date newbirthday );

    /**
     * 显示所有学生信息
     * @return
     */
    List<Student> showAllStudent();


    /**
     * 显示带有所课程信息的教师信息
     * @return
     */
    List<Teacher> showAllTeacherWithCourse();


    /**
     * 更新学生信息
     * @param student
     * @return
     */
    int updateStuInfo(Student student);

    /**
     * 更新教师信息
     * @param teacher
     * @return
     */
    int updateTeaInfo(Teacher teacher);

    /**
     * 更新课程信息
     * @param course
     * @return
     */
    int updateCourseInfo(Course course);


}
