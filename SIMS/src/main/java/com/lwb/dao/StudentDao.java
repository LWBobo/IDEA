package com.lwb.dao;

import com.lwb.pojo.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    /**
     * 获取所有学生信息
     * @return
     */
    @Select("select * from student")
    List<Student> findAll();


    /**
     * 根据课程号获取学生信息
     * @param cnum
     * @return
     */
    @Select("select * from student where s_num in (select s_num from stu_cours_sele where c_num = #{cnum})")
    List<Student> findStudentByCourse(String cnum);

    /**
     * 获取所有学生信息,并且附带学生选课表 1:n
     * @return
     */
    @Results({@Result(id = true,column = "s_num",property = "snum"),
            @Result(column = "s_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursByStuId",fetchType = FetchType.LAZY))
    })
    @Select("select * from student")
    List<Student> findAllWithCourse();

    /**
     * 根据用户的编号获取用户信息
     * @param snum
     * @return
     */
    @Results({@Result(id = true,column = "s_num",property = "snum"),
            @Result(column = "s_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursByStuId",fetchType = FetchType.LAZY))
    })
    @Select("select * from student where s_num = #{snum}")
    Student findWithCourseById(String snum);


}
