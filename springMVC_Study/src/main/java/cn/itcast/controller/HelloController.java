package cn.itcast.controller;


import cn.itcast.pojo.User;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(path = "/user")
@SessionAttributes(value = {"user"})
public class HelloController {


    @RequestMapping(path = "/hello")
    public String sayHello(String username){
        System.out.println("Hello SpringMVC" + username);

        return "success";
    }

    @RequestMapping(path = "/userbean")
    public String testUserBean(HttpServletResponse resp , HttpServletRequest req, User u){
        System.out.println(u.toString());
        HttpSession hs = req.getSession();
        hs.setAttribute("name",u.getName());
        try {
            resp.sendRedirect("../user/s1.jsp");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/testModoAttribute")
    public String testModoAttribute(Model model, User u){

        System.out.println("执行了testModoAttribute");
        System.out.println(u);
        model.addAttribute("user",u);

        return "success";
    }


/*
    @ModelAttribute
    public User showUser(String name){
        User u = new User();
        u.setName(name);
        u.setSex("女");
        u.setAddress("河南");
        System.out.println("执行了showUser");
        System.out.println(u);
        return u;

    }
*/

    @RequestMapping("/testVoid")
    public void testvoid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
      //  req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
        return;

    }


    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(HttpServletRequest req){

        //  return "forward:/WEB-INF/pages/success.jsp";
        return  "redirect:/user.jsp";
    }


    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了....");
        //客户端发送的ajax请求，后端自动把json字符串封装到user对象中
        System.out.println(user);
        user.setName("hehe");


        return user;



    }

}
