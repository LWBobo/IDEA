package com.lwb.contextmap;

import com.opensymphony.xwork2.ActionSupport;

import java.util.*;

public class ListValueStack extends ActionSupport {

    //action提供属性，并提供get方法，这个属性数据就会被存在值栈
    private List<Student> stuList;

    public List<Student> getStuList() {
        return stuList;
    }

    public String list(){
        //jsp一般从值栈取数据
        stuList = new ArrayList<Student>();
        stuList.add(new Student("gyf", 28, "广州"));
        stuList.add(new Student("wxs", 18, "潮汕"));
        stuList.add(new Student("lwf", 38, "韶关"));
        stuList.add(new Student("hxl", 98, "湖南"));
        stuList.add(new Student("ggl", 48, "河源"));
        stuList.add(new Student("lp", 8, "湖北"));


        return "list";
    }

}
