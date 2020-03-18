package com.lwb.i18n.i18n_action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Locale;
import java.util.ResourceBundle;

public class UserAction extends ActionSupport {

    //com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor
    //读取资源包数据-读取资源顺序【局部-包级别-全局】
    //包级别的  必须以package开头
    public String login(){

        System.out.println("com.lwb.i18n.i18n_action.UserAction.login");
        System.out.println(getText("login.username"));
        System.out.println(getText("login.password"));
        System.out.println(getText("login.submit"));


        return NONE;
    }

}
