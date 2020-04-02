package com.lwb.mapper;


import com.lwb.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getAll();

    @Select("select * from student where id =#{id}")
    Student findById(String id);

    @Delete("delete from student where id = #{id}")
    int delById(String id);

    @Update({
            "<script>",
            "update student ",
            "<set>",
            "<if test='name != null'>","name = #{name},","</if>",
            "<if test='sex != null'>","sex = #{sex},","</if>",
            "<if test='address != null'>","address = #{address},","</if>",
            "<if test='jeescore != null'>","jeescore = #{jeescore},","</if>",
            "</set>",
            "where id = #{id}",
            "</script>"
    })
    int updateStudent(Student s);

    @Insert("insert into student(id,name,age,sex,address,jeescore) values (#{id},#{name},#{age},#{sex},#{address},#{jeescore})")
    int addStudent(Student student);

    @Select("select * from student where id = #{id} and password = #{password}")
    Student stuLogin(@Param(value = "id") String id,@Param(value = "password") String password);
}
