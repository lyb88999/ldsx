package com.highcom.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController2 {
    @ResponseBody
    @RequestMapping("/hello2")
    public String hello() throws Exception {
        return "hello world!";
    }
}
