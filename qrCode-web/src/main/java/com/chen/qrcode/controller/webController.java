package com.chen.qrcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class webController {
    @RequestMapping("/")
    String home(){
        return "Hello World";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg","跟一一哥学习SpringBoot中使用JSP功能!");
        //要跳转到的页面视图名称
        return "index";
    }
}
