package com.lwb.dao;

import com.lwb.pojo.LabCourse;
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

}
