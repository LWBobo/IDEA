package com.lwb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;



//声明该类是一个springboot的引导类
@SpringBootApplication
//开启注解配置缓存
//@EnableCaching
public class MySpringBootApplication {



    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class,args);

    }


}