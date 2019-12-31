package com.lwb.dao;

import com.lwb.pojo.Lab;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LabDao {

    /**
     * 获取所有的实验室信息
     * @return
     */
    @Select("select * from lab")
    List<Lab> findAllLab();
}
