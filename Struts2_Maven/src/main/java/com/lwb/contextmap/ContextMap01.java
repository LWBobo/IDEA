package com.lwb.contextmap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ContextMap01 extends ActionSupport {

    @Override
    public String execute() throws Exception {


        ActionContext contextMap = ActionContext.getContext();

        //向cotextMap存数据
        contextMap.put("username","liuuwenbo");
        contextMap.put("age",21);

        //往cotextMap的session存数据
        Map<String, Object> session = contextMap.getSession();
        session.put("username","session_liuwenbo");
        session.put("pwd","session_123");


        //4.往cotextMap的request存数据
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("username", "request_liuwenbo");

        //5.往cotextMap的application存数据
        //application = ServletContext 【ServletActionContext.getServletContext()】
        Map<String, Object> applicationMap = contextMap.getApplication();

        applicationMap.put("username", "applicatio_liuwenbo");

        return super.execute();
    }
}
