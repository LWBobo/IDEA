package com.lwb.action;


import com.lwb.pojo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LogInAction3 extends ActionSupport implements ModelDriven<User> {
	

	public String login(){

		//获取请求参数
		//第一种方法：通过request对象
/*		HttpServletRequest request =  ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");*/
		
		//第二种方式：通过属性的set注入
		
		//第三种方式：通过set模型属性
		//System.out.println(user);
	
		/**
		 * 第四种方式: 通过模型驱动【最常用】
		 * 实现步骤：
		 * 1.在action里实现一个模型驱动接口
		 * 2.提供一个模型属性，并一定要赋值
		 * 通过这种方式，在jsp页面中就不用写user.
		 * 
		 * 这是模型驱动的原理是因为有个模型驱动的拦截器在处理
		 * 这个类就com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor
		 */
		System.out.println("LogInAction3.login()");
		System.out.println(user);
		
		
		//NONE不跳转，也就是不用找result标签
		return NONE;
	}

	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
