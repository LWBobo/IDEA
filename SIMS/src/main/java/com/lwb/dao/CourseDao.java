package com.lwb.dao;

import com.lwb.pojo.Course;
import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CourseDao {

    /**
     * 查询所有课程信息
     * @return
     */
    @Select("select * from course")
    List<Course> findAll();

    /**
     * 根据课程号获取不带有学生信息的课程信息
     * @param cnum
     * @return
     */
    @Select("select * from course where c_num = #{cnum}")
    Course findCourseNoWithStuById(String cnum);


    /**
     * 根据学生id获取所有课程信息
     * @return
     */
    @Select("select * from course where c_num in (select c_num from stu_cours_sele where s_num = #{snum}) ")
    List<Course> selAllCoursByStuId(String snum);


    /**
     * 根据学生号获取带有教师信息的课程信息
     * @param snum
     * @return
     */
    @Results({@Result(id = true,column = "c_num",property = "cnum"),
            @Result(column = "c_num",property = "teacher",one = @One(select = "com.lwb.dao.TeacherDao.findTeaByCnum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course where c_num in (select c_num from stu_cours_sele where s_num = #{snum}) ")
    List<Course> selAllCoursWithTeaByStuId(String snum);

    /**
     * 根据学生号获取带有教师信息和成绩的课程信息
     * @param snum
     * @return
     */
    @Results({@Result(id = true,column = "c_num",property = "cnum"),
            @Result(column = "c_grade",property = "cgrade"),
            @Result(column = "c_num",property = "teacher",one = @One(select = "com.lwb.dao.TeacherDao.findTeaByCnum",fetchType = FetchType.LAZY))

    })
    @Select("select course.*,stu_cours_sele.c_grade from course,stu_cours_sele where course.c_num in (select c_num from stu_cours_sele where s_num = #{snum}) and  course.c_num = stu_cours_sele.c_num and stu_cours_sele.s_num = #{snum}")
    List<Course> selAllCoursWithTeaAndGradeByStuId(String snum);

    /**
     * 根据教师号获取教师所教课程信息
     * @param tnum
     * @return
     */
    @Select("select * from course where c_num in (select c_num from tea_cours_teach where t_num = #{tnum})")
    List<Course> selAllCoursByTeaId(String tnum);


    /**
     * 获取所有课程信息,包括课程所选的学生
     * @return
     */
    @Results({@Result(id = true,column = "c_num", property = "cnum"),
            @Result(column = "c_num",property = "students",many = @Many(select = "com.lwb.dao.StudentDao.findStudentByCoursenum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course")
    List<Course> selAllCourseWithStu();


    /**
     * 根据课程号获取带有学生信息的课程信息
     * @param cnum
     * @return
     */
    @Results({@Result(id = true,column = "c_num", property = "cnum"),
            @Result(column = "c_num",property = "students",many = @Many(select = "com.lwb.dao.StudentDao.findStudentByCoursenum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course where c_num = #{cnum}")
    Course findCourseWithStuBycId(String cnum);


    /**
     * 获取所有带有教师信息的课程信息
     * @return
     */
    @Results({@Result(id = true,column = "c_num",property = "cnum"),
            @Result(column = "c_num",property = "teacher",one = @One(select = "com.lwb.dao.TeacherDao.findTeaByCnum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course")
    List<Course> findAllCourseWithTea();


    /**
     *根据课程号带有教师信息的课程信息
     * @return
     */
    @Results({@Result(id = true,column = "c_num",property = "cnum"),
            @Result(column = "c_num",property = "teacher",one = @One(select = "com.lwb.dao.TeacherDao.findTeaByCnum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course where c_num = #{cnum}")
    Course findCourseWithTeaByid(String cnum);


    /**
     * 获取所有带有学生信息以及教师信息的课程信息
     * @return
     */
    @Results({@Result(id = true,column = "c_num",property = "cnum"),
            @Result(column = "c_num",property = "teacher",one = @One(select = "com.lwb.dao.TeacherDao.findTeaByCnum",fetchType = FetchType.LAZY)),
            @Result(column = "c_num",property = "students",many = @Many(select = "com.lwb.dao.StudentDao.findStudentByCoursenum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course")
    List<Course> findAllCourseWithTeaAndStu();


    /**
     * 根据课程号获取所有带有学生信息以及教师信息的课程信息
     * @return
     */
    @Results({@Result(id = true,column = "c_num",property = "cnum"),
            @Result(column = "c_num",property = "teacher",one = @One(select = "com.lwb.dao.TeacherDao.findTeaByCnum",fetchType = FetchType.LAZY)),
            @Result(column = "c_num",property = "students",many = @Many(select = "com.lwb.dao.StudentDao.findStudentByCoursenum",fetchType = FetchType.LAZY))

    })
    @Select("select * from course where c_num = #{cnum}")
    Course findAllCourseWithTeaAndStuByCnum(String cnum);



    @Update({
            "<script>",
            "update course ",
            "<set>",
            "<if test='cname != null'>","c_name = #{cname},","</if>",
            "<if test='ccredit != null'>","c_credit = #{ccredit},","</if>",
            "<if test='cbegintime != null'>","c_begintime = #{cbegintime},","</if>",
            "<if test='cendtime != null'>","c_endtime = #{cendtime},","</if>",
            "</set>",
            "where c_num = #{cnum}",
            "</script>"
    })
    int updateCourseInfo(Course c);
}
