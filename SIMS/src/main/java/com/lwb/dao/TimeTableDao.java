package com.lwb.dao;

import com.lwb.pojo.TimeTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface TimeTableDao {

    /**
     * 根据课表id获取课表
     * @return
     */
    @Select("select * from timetable where tableid = #{tableid}")
    TimeTable findTableById(String tableid);


    /**
     * 插入一条课程信息
     * @param timeTable
     * @return
     */
    @Insert("insert into timetable values (#{tableid},#{monday1},#{monday2},#{monday3},#{monday4},#{monday5}," +
            "#{tuesday1},#{tuesday2},#{tuesday3},#{tuesday4},#{tuesday5}," +
            "#{wednesday1},#{wednesday2},#{wednesday3},#{wednesday4},#{wednesday5}," +
            "#{thursday1},#{thursday2},#{thursday3},#{thursday4},#{thursday5}," +
            "#{friday1},#{friday2},#{friday3},#{friday4},#{friday5})")
    int insertTimeTable(TimeTable timeTable);


    /**
     * 删除一个课程表纪录
     * @param tableid
     * @return
     */
    @Delete("delete from timetable where tableid = #{tableid}")
    int delTimeTable(String tableid);
}
