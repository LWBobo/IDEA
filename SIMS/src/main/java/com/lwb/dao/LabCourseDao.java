package com.lwb.dao;

import com.lwb.pojo.LabCourse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LabCourseDao {

    /**
     * 根据课程号获取对应的实验课程信息
     * @param cnum
     * @return
     */
    @Select("select * from labcourse where lc_ccnum = #{cnum}")
    LabCourse findLabCourseByCnum(String cnum);


    /**
     * 根据实验课程号获取实验课程信息
     * @param lcnum
     * @return
     */
    @Select("select * from labcourse where lc_num = #{lcnum}")
    LabCourse findLabCourseByLcnum(String lcnum);


    /**
     * 向数据库添加一个实验课
     * @param labCourse
     * @return
     */
    @Insert("insert into labcourse values (#{lcnum},#{lcname},#{lcccnum},#{lcccname},#{lcclassroomnumber})")
    int insertLabCourse(LabCourse labCourse);

    /**
     * 根据实验课程号删除一个实验课
     * @param lcnum
     * @return
     */
    @Delete("delete from labcourse where lc_num = #{lcnum}")
    int delLabCourse(String lcnum);

}
