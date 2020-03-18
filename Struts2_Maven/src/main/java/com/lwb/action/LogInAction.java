package com.lwb.action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class LogInAction {

    /*
    自动传入参数
     */
    private String username;
    private String password;
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

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

    public String login(){

        System.out.println("com.lwb.action.LogInAction.login");
/*        HttpServletRequest request =  ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");*/


        //第二种方式：通过属性的set注入

        System.out.println(username);
        System.out.println(password);
        return "success";
    }
}
