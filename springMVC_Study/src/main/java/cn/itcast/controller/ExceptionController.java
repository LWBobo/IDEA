package cn.itcast.controller;

import cn.itcast.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exception")
public class ExceptionController {

    @RequestMapping(value = "/testExcrption")
    public String testExcrption() throws  Exception{
        System.out.println("testExcrption执行了...");


        try {
            int a = 10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            throw  new SysException("出现错误！");
        }

        return "success";
    }
}
