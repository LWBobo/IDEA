package com.lwb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/err")
public class ErrController {


    @RequestMapping("/test")
    public String test() throws SQLException, IOException {

       double num = Math.random();

       if(num - 0.5 >0){
           throw new SQLException();
       }else {
           throw new IOException();
       }


    }

    /**
     * 局部异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = {java.sql.SQLException.class})
    public ModelAndView nullpointExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("nullpointerr",e.toString());
        mv.setViewName("error/sqlerr");
        return mv;
    }
}
