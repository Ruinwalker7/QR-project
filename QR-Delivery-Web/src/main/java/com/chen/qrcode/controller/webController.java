package com.chen.qrcode.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class webController {

    @RequestMapping("/")
    public String home(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginWeb(){
        return "login";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.setAttribute("loggedIn",false);
        return "redirect:/";
    }

    @RequestMapping("/man")
    public String man(){
        return "man";
    }

    @RequestMapping("/delivery")
    public String delivery(){
        return "delivery";
    }

    @RequestMapping("/customer")
    public String customer(){
        return "customer";
    }

    @GetMapping("/index")
    public String index() {
        //要跳转到的页面视图名称
        return "index";
    }

    @GetMapping("/address")
    public String address() {
        //要跳转到的页面视图名称
        return "address";
    }
}
