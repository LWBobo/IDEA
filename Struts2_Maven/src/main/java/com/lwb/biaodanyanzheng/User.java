package com.lwb.biaodanyanzheng;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {

	private String username;
	private String password;
	private Date birthday;
	private String hobby;
	private boolean married;
	
	/*private Map<String,String> errMsg = new HashMap<String,String>();
	public boolean validate(){
		//判断字段数据
		if(username == null && "".equals(username)){
			errMsg.put("username", "用户名不能为空");
		}
		
		return errMsg.size() == 0;
	}*/
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", birthday=" + birthday + ", hobby=" + hobby
				+ ", married=" + married + "]";
	}
	
	
	
}
