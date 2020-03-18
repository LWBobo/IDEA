package com.lwb.servlet;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetServlet {
    public String test(){
        //获取servlet 的api方式
        //第一种方式：通过ServletActionContext
        //1.response
        HttpServletResponse response = ServletActionContext.getResponse();

        //2.request
        HttpServletRequest request = ServletActionContext.getRequest();

        //3.session
        HttpSession session =  request.getSession();

        //4.application【ServletContext】
        ServletContext application = ServletActionContext.getServletContext();


/*		org.apache.struts2.dispatcher.StrutsRequestWrapper@78271a91 属于struts
 *
		org.apache.catalina.connector.ResponseFacade@2271bd05 属于Tomcat

		org.apache.catalina.session.StandardSessionFacade@4b6053c2 属于Tomcat

		org.apache.catalina.core.ApplicationContextFacade@3c7fbc3b 属于Tomcat
		*/


        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        System.out.println(application);

        //NONE不跳转，也就是不用找result标签
        return "none";
    }
}
