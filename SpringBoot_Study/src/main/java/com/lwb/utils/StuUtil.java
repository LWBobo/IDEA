package com.lwb.utils;

import com.lwb.entity.Student;
import com.lwb.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StuUtil {
    @Autowired
    private StudentMapper studentMapper;


    public List<Student> getAll(){
        return studentMapper.getAll();
    }


    public int insertStu(Student student){
        return studentMapper.addStudent(student);
    }

    public int delStu(String id){
        return studentMapper.delStudent(id);
    }
}
