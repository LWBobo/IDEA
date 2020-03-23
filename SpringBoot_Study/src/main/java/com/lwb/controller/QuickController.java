package com.lwb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class QuickController {
    //注解获取配置文件中的数据
    @Value("${stuname}")
    private String name;

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return name +"你好   /Hello SpringBoot";
    }
}
