package com.lwb.biaodanyanzheng;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	
	private Student stu = new Student();
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return stu;
	}


	/**
	 * 通过配置文件验证
	 * @return
	 */
	public String add(){
		System.out.println(stu);

		return NONE;
	}


	
	
}
