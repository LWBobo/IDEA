package com.lwb.intercept.login;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user = new User();
	
	public String login(){

		//1.接收参数
		//2.判断登录成功与否
		if("lwb".equals(user.getUsername()) && "123".equals(user.getPassword())){
			//登录成功，把user保存到session
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}
		return NONE;
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
