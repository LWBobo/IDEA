package com.lwb.controller;


import com.lwb.entity.Student;
import com.lwb.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/getall")
    @ResponseBody
    /**
     * cachename/value:指定缓存组件的名称
     * key:缓存数据使用的key 默认是方法的参数值
     *      编写spel：#参数（参数的值）  #a0  #p0  #root.args[0]
     */
    @Cacheable(cacheNames = "findallStu",key = "#root.methodName")   //方法的名字
    public List<Student> getAllStu(){

        List<Student> all = studentMapper.getAll();

        return all;

    }

    @ResponseBody
    @RequestMapping("/find")
    @Cacheable(value = "find",key = "#id",unless = "#result == null")  //若结果为空 则不缓存
    public Student findByid(String id){
        return studentMapper.findById(id);
    }



}
