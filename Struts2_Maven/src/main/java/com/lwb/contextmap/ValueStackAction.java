package com.lwb.contextmap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//往ValueStack【值栈】存数据
		
		//1.获取ValueStack
		ValueStack vs1 = ActionContext.getContext().getValueStack();
		
		//2.存对象
		//1.put方法：往栈顶添加数据
		vs1.push(new User("ValueStack_liuwenbo01", "ValueStack_123"));
		vs1.push(new User("ValueStack_liuwenbo02", "ValueStack_123456"));

		//2.setValue方法:更改栈顶的username的值
		/**
		 * 如果栈里没有这key会报错,vs.setValue("username2", "gyf03");
		 * Error setting expression 'username2' with value 'gyf03' - [unknown location]
		 */
	//	vs1.setValue("username","setvalue");
	//	vs1.setValue("username","setvalue02");


		//name前面加#号，修改contextMap中的值
		vs1.setValue("#username","setvalue002");


		//3.set方法 :往值栈存map数据
		vs1.set("user", new User("刘文博", "187"));

		
		//3.获取值栈的另外两种方法
		ValueStack vs2 = (ValueStack) ServletActionContext.getRequest().getAttribute("struts.valueStack");
		System.out.println(vs1);
		System.out.println(vs2);
		
		return SUCCESS;
	}


}
