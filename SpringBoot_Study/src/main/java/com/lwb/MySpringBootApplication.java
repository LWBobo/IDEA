package com.lwb;

import com.lwb.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Scanner;


//声明该类是一个springboot的引导类
@SpringBootApplication
//开启注解配置缓存
@EnableCaching
public class MySpringBootApplication implements CommandLineRunner{

    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);

    }

    @Override
    public void run(String... args) throws Exception {

        while (true){
            System.out.println("请输入：");
            Scanner in = new Scanner(System.in);
            String str = in.nextLine();
            System.out.println(str);
            if(str.equals("quit")){
                return;
            }
        }


    }
}