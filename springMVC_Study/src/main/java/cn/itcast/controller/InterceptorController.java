package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {


    @RequestMapping(value = "/testinterceptor")
    public String testInterceptor(){

        System.out.println("testInterceptor执行了...");


        return "error";
    }
}