package com.lwb.dao;

import com.lwb.pojo.ClassSchedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ClassScheduleDao {
    /**
     * 获取所有的课程排课表
     * @return
     */
    @Select("select * from classschedule")
    List<ClassSchedule> findAll();
}
