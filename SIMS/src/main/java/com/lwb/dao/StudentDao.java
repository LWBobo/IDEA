package com.lwb.dao;

import com.lwb.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.Date;
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
    List<Student> findStudentByCoursenum(String cnum);

    /**
     * 获取所有学生信息,并且附带学生选课表,教师信息 1:n
     * @return
     */
    @Results({@Result(id = true,column = "s_num",property = "snum"),
            @Result(column = "s_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursWithTeaByStuId",fetchType = FetchType.LAZY))
    })
    @Select("select * from student")
    List<Student> findAllWithCourseAndTea();

    /**
     * 获取所有学生信息,并且附带学生选课表,教师信息,课程分数 1:n
     * @return
     */
    @Results({@Result(id = true,column = "s_num",property = "snum"),
            @Result(column = "s_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursWithTeaAndGradeByStuId",fetchType = FetchType.LAZY))
    })
    @Select("select * from student")
    List<Student> findAllWithCourseAndTeaAndGrade();

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


    /**
     * 根据用户的编号获取用户信息带有成绩还有课程信息
     * @param snum
     * @return
     */
    @Results({@Result(id = true,column = "s_num",property = "snum"),
            @Result(column = "s_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursWithTeaAndGradeByStuId",fetchType = FetchType.LAZY))
    })
    @Select("select * from student where s_num = #{snum}")
    Student findWithCourseAndGradeById(String snum);


    /**
     * 修改学生信息
     * @param snum
     * @param newname
     * @param newsex
     * @param newtel
     * @param newaddress
     * @param newbirthday
     * @return
     */
    @Update("update student set s_name = #{newname},s_sex=#{newsex},s_tel=#{newtel},s_address=#{newaddress},s_birthday=#{newbirthday} where s_num =#{snum}")
    int ChStuInfo(@Param("snum") String snum,@Param("newname")String newname,@Param("newsex")String newsex,@Param("newtel")String newtel,@Param("newaddress")String newaddress,@Param("newbirthday") Date newbirthday);

    @Update("update")
    int chStuInfomation(Student student);
}
