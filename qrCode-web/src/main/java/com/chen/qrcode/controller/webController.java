package com.chen.qrcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class webController {
    @RequestMapping("/")
    String home(){
        return "Hello World";
    }
}
