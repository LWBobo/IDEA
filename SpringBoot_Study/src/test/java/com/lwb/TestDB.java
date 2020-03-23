package com.lwb;

import com.lwb.entity.Student;
import com.lwb.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MySpringBootApplication.class)
@RunWith(SpringRunner.class)
public class TestDB {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testDB(){
        System.out.println(studentMapper.findById("1010"));
    }
    @Test
    public void testDel(){
        int index = studentMapper.delStudent("1010");
        if(index == 1){
            System.out.println("删除成功!");
            System.out.println(studentMapper.getAll());
        }
    }

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setId("1010");
        student.setName("刘文博");
        student.setAddress("河南");
        student.setSex("男");
        student.setAge(23);
        student.setJeescore(90);
        System.out.println(student);
        int index = studentMapper.addStudent(student);
        if(index == 1){
            System.out.println("添加成功！");
            System.out.println(studentMapper.getAll());
        }
    }
}
