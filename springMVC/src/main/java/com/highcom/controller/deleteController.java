package com.highcom.controller;

import com.highcom.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class deleteController implements Controller {


    @Autowired
    private EmpService empService;
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        int ok = empService.deleteEmpByEmpno(Integer.valueOf(httpServletRequest.getParameter("empno")));
        if(ok > 0){

        }
        // mv.setViewName("success.jsp");
        return mv;
    }
}
