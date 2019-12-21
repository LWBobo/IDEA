package com.lwb.dao;

import com.lwb.pojo.Teacher;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface TeacherDao {
    /**
     * 查询所有教师信息
     * @return
     */
    @Select("select * from teacher")
    List<Teacher> findAll();

    /**
     * 获取所有教师信息,带有所教授的课程信息
     * @return
     */
    @Results({@Result(id = true,column = "t_num",property = "tnum"),
            @Result(column = "t_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursByTeaId",fetchType = FetchType.LAZY))

    })
    @Select("select * from teacher")
    List<Teacher> findAllTeaWitnCourse();


    /***
     * 根据教师编号获取带有课程信息的教师信息
     * @param tnum
     * @return
     */
    @Results({@Result(id = true,column = "t_num",property = "tnum"),
            @Result(column = "t_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursByTeaId",fetchType = FetchType.LAZY))

    })
    @Select("select * from teacher where t_num = #{tnum}")
    Teacher findTeaWitnCourseById(String tnum);

    /**
     * 根据教师编号获取不带有课程信息的教师信息
     * @param tnum
     * @return
     */
    @Select("select * from teacher where t_num = #{tnum}")
    Teacher findTeaNoWitnCourseById(String tnum);

    /**
     * 根据课程号在中间表中获取唯一的教师信息
     * @param cnum
     * @return
     */
    @Select("select * from teacher where t_num = (select t_num from tea_cours_teach where c_num = #{cnum})")
    Teacher findTeaByCnum(String cnum);




    @Update({
            "<script>",
            "update teacher ",
            "<set>",
            "<if test='tname != null'>","t_name = #{tname},","</if>",
            "<if test='tsex != null'>","t_sex = #{tsex},","</if>",
            "<if test='ttitle != null'>","t_title = #{ttitle},","</if>",
            "<if test='tbirthday != null'>","t_birthday = #{tbirthday},","</if>",
            "</set>",
            "where t_num = #{tnum}",
            "</script>"

    })
    int updateTeaInfo(Teacher t);



}
