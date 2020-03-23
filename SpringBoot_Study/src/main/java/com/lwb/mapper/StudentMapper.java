package com.lwb.mapper;

import com.lwb.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    List<Student> getAll();

    Student findById(String id);

    int addStudent(Student student);

    int delStudent(String id);
}
