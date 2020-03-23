package com.lwb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwb.entity.Student;
import com.lwb.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MySpringBootApplication.class)
@RunWith(SpringRunner.class)
public class TestRedis {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testRedis() throws JsonProcessingException {
        String userListJson = redisTemplate.boundValueOps("user.findall").get();
        ObjectMapper objectMapper = new ObjectMapper();
        if(null == userListJson){  //如果缓存中不存在
            //从数据库中查询
            List<Student> all = studentMapper.getAll();
            //将查询出的数据存入redis

            //将list集合转化为json格式的字符串
            try {
                userListJson = objectMapper.writeValueAsString(all);
                redisTemplate.boundValueOps("user.findall").set(userListJson);
                System.out.println("----------------数据库中查询------------------------");
                System.out.println(all);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("--------------从缓存中查询-----------------");

            System.out.println(userListJson);

            List<Student> studentList = new ArrayList<>();
            try {
                studentList = objectMapper.readValue(userListJson,studentList.getClass());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(studentList);
        }



    }


    @Test
    public void testRedis222(){
        String userListJson = redisTemplate.boundValueOps("findbyid").get();
        ObjectMapper objectMapper = new ObjectMapper();
        if(null == userListJson){  //如果缓存中不存在
            //从数据库中查询
            Student student = studentMapper.findById("1002");
            //将查询出的数据存入redis

            //将list集合转化为json格式的字符串
            try {
                userListJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
                redisTemplate.boundValueOps("findbyid").set(userListJson);
                System.out.println("----------------数据库中查询------------------------");
                System.out.println(student);
                System.out.println("json:" + userListJson);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("--------------从缓存中查询-----------------");

            System.out.println(userListJson);

            Student s = new Student();
            try {
                s = objectMapper.readValue(userListJson, Student.class);
            } catch (Exception e) {
                System.out.println("遇到问题*****");
                e.printStackTrace();
            }
            System.out.println(s);
        }



    }
}
