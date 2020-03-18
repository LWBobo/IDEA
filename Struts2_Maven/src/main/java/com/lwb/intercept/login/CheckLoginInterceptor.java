package com.lwb.intercept.login;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 校验登录的拦截器
 * @author gyf
 *
 */
public class CheckLoginInterceptor extends MethodFilterInterceptor{
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("校验登录的拦截器....");
		// TODO Auto-generated method stub
		//1.获取sesson的user
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		//2.判断
		if(user != null){//放行
			return invocation.invoke();
		}
		
		//如果没有登录，回到登录页面
		return "toLoginPage";
	}

}
