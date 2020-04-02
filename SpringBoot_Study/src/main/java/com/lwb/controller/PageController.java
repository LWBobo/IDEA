package com.lwb.controller;

import com.lwb.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/{page}")
    public String page(@PathVariable String page, Student student){

        return page;
    }
}
