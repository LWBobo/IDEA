package com.lwb.dao;

import com.lwb.pojo.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherDao {
    /**
     * 查询所有教师信息
     * @return
     */
    @Select("select * from teacher")
    List<Teacher> findAll();
}
