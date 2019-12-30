package com.lwb.dao;

import com.lwb.pojo.TimeTable;
import org.apache.ibatis.annotations.Select;

public interface TimeTableDao {

    /**
     * 根据课表id获取课表
     * @return
     */
    @Select("select * from timetable where tableid = #{tableid}")
    TimeTable findTableById(int tableid);
}
