package com.chen.qrcode.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class webController {

    @RequestMapping("/")
    public String home(){
        return "login";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.setAttribute("loggedIn",false);
        return "redirect:/";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg","早上好！");
        //要跳转到的页面视图名称
        return "index";
    }
}
