package com.lwb.controller;

import com.lwb.entity.Student;
import com.lwb.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {
    @Autowired
    private StuService stuService;

    @RequestMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd,Model model,HttpSession session){
        Student student = stuService.stuLogin(id,pwd);
        if(student != null){  //登陆成功

            //登陆成功，存入session
            session.setAttribute("loginuser",student);

            return "redirect:/success.html";
        }else{
            model.addAttribute("msg","用户名或密码错误！！");
            return "index";
        }


    }


    @RequestMapping("/showall")
    public String showAll(Model model){
        List<Student> studentList = stuService.getAll();
        model.addAttribute("allstu",studentList);

        return "stu_list";

    }

    @RequestMapping("/addstu")
    public String addStu(Model model,Student student){
        if(student.getId().equals("") || student.getAddress().equals("")||student.getAge() == 0
                ||student.getJeescore() == 0||student.getName().equals("") || student.getSex().equals("")){
            return "false";
        }
        Student student1 = stuService.insertStu(student);
        //System.out.println(student);
        if(student1!= null){
           return showAll(model);

        }else {
            return "false";
        }

    }

    @RequestMapping("/delstu")
    public String delStuById(Model model,String id){
        int index = stuService.delStu(id);
        if(index > 0){
            return showAll(model);
        }else {
            return "false";
        }
    }

}
