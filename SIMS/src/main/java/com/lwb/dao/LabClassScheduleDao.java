package com.lwb.dao;

import com.lwb.pojo.LabClassSchedule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
    @Insert("insert into labclassschedule (lc_num,lc_name,monday,tuesday,wednesday,thursday,friday) values " +
            "(#{lcnum},#{lcname},#{monday},#{tuesday},#{wednesday},#{thursday},#{friday})")
    int addLabClassSchedule(LabClassSchedule l);

    /**
     * 根据实验课程号删除一个实验安排
     * @param lcnum
     * @return
     */
    @Delete("delete from labclassschedule where lc_num = #{lcnum}")
    int delLabClassSchedule(String lcnum);

}
