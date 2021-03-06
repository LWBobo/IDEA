package com.lwb.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.lwb.dao.UserDao;
import com.lwb.dao.impl.UserDaoImpl;
import com.lwb.pojo.User;
import com.lwb.service.UserService;

public class UserServiceImpl implements UserService{
	
	//声明日志对象
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	//声明Dao层对象
	UserDao ud=new UserDaoImpl();
	//用户登录
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		//打印日志
		logger.debug(uname+"发起登录请求");
		User u=ud.checkUserLoginDao(uname, pwd);
		//判断
		if(u!=null){
			logger.debug(uname+"登录成功");
		}else{
			logger.debug(uname+"登录失败");

		}
		return u;
	}

}
