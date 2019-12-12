package com.lwb.dao;

import com.lwb.pojo.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseDao {

    /**
     * 查询所有课程信息
     * @return
     */
    @Select("select * from course")
    List<Course> findAll();


    /**
     * 根据学生id获取所有课程信息
     * @return
     */
    @Select("select * from course where c_num in (select c_num from stu_cours_sele where s_num = #{snum}) ")
    List<Course> selAllCoursByStuId(String snum);
}
