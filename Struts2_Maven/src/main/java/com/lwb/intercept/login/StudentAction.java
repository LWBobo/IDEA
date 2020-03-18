package com.lwb.intercept.login;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentAction extends ActionSupport{



	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String list(){
		System.out.println("StudentAction id:" + id);
		return SUCCESS;

	}

}
