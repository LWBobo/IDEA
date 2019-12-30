package com.lwb.dao;

import com.lwb.pojo.LabClassSchedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LabClassScheduleDao {
    /**
     * 获取所有的实验课程安排表
     * @return
     */
    @Select("select * from labclassschedule")
    List<LabClassSchedule> findAll();


    /**
     * 根据实验课编号获取实验课程表
     * @param lcnum
     * @return
     */
    @Select("select * from labclassschedule where lc_num = #{lcnum}")
    LabClassSchedule findScheduleByLcnum(String lcnum);

    /**
     * 添加一条实验课程信息
     * @param l
     * @return
     */

    int addLabClassSchedule(LabClassSchedule l);

}
