package com.lwb.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Myintercept extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("拦截前");
        //等于放行
        String returnstr = actionInvocation.invoke();
        System.out.println("拦截后");

        return returnstr;
    }
}
