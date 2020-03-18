package com.lwb.action;

import com.lwb.pojo.User;

public class LogInAction2 {

    /*
    自动传入参数
     */
    private User user;

    public LogInAction2() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login(){

/*        HttpServletRequest request =  ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");*/


        //第二种方式：通过属性的set注入

        System.out.println(user);
        return "none";
    }
}
