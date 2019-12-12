package com.lwb.dao;

import com.lwb.pojo.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentDao {

    /**
     * 获取所有学生信息
     * @return
     */
    @Select("select * from student")
    List<Student> findAll();


    /**
     * 获取所有学生信息,并且附带学生选课表 1:n
     * @return
     */
    @Results({@Result(id = true,column = "s_num",property = "snum"),
            @Result(column = "s_num",property = "courses",many = @Many(select = "com.lwb.dao.CourseDao.selAllCoursByStuId",fetchType = FetchType.LAZY))
    })
    @Select("select * from student")
    List<Student> findAllWithCourse();


}
