package com.lwb.biaodanyanzheng;



import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	 
	
	/**
	 * struts2自带表单字段的验证
	 * 
	 * 第一种：重写validate方法,如果数据不对，可以往FieldError添加字段错误信息
	 * 注意：
	 * 1.表单一定要用struts的标签：s:form/s:textfield
	 * 2.addFieldError里的key，是表单的name的值
	 * 3.validate对于Action来说是全局，也就是action的所有方法都会生效
	 * 4.在不需要验证的action方法上，可以声明一个注解@SkipValidation,忽略校验
	 * @return
	 * 
	 * 第二种:写一个方法，格式：validate+方法名(第一个字母大写)
	 * 		【validateRegister】
	 * 注意：
	 * 1.只针对方法有效,它是一个局部字段校验
	 */
	
/*	@Override
	public void validate() {
		//判断用户名是否为空
		//if(username == null && "".equals(username))
		if(StringUtils.isEmpty(user.getUsername())){
			addFieldError("username", "用户名不能为空");
		}
		
		//判断密码是否为空
		if(StringUtils.isEmpty(user.getPassword())){
			addFieldError("password", "密码不能为空");
		}
	}
	*/
	
	public String register(){
		//com.opensymphony.xwork2.validator.validators.RequiredStringValidator
		System.out.println("register方法....");
		System.out.println(user);
		return NONE;
	}

	/**
	 * 返回一个列表
	 * @return
	 */
	//跳过验证
	//@SkipValidation
	public String list(){
		return "success";
	}
	
}
