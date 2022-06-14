package com.highcom.controller;

import com.highcom.po.Emp;
import com.highcom.po.User;
import com.highcom.service.EmpService;
import com.highcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class userLoginController implements Controller {

    @Autowired
    private UserService userService;

    @Autowired
    private EmpService empService;



    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        String username = httpServletRequest.getParameter("uname");
        String password = httpServletRequest.getParameter("pwd");
        System.out.println(username+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User ReturnUser = userService.login(user);
        if(ReturnUser!=null){
            httpServletRequest.getSession().setAttribute("userInfo",user);
            List<Emp> empList = empService.findAll();
            mv.addObject("empList",empList);
            mv.setViewName("success.jsp");
        }else{
            mv.addObject("msg","登陆失败");
            mv.setViewName("login.jsp");
        }
        return mv;
    }
}
