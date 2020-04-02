package com.lwb.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(value = {java.io.IOException.class})
    public ModelAndView nullpointExceptionHandler(Exception e){
        ModelAndView mv = new ModelAndView();
        mv.addObject("nullpointerr",e.toString());
        mv.setViewName("error/ioerr");
        return mv;
    }
}
