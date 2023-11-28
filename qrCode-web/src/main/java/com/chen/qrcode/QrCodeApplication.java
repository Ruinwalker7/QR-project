package com.chen.qrcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;


//@SpringBootApplication
@RestController
@EnableAutoConfiguration //开启自动配置
public class QrCodeApplication {

    @RequestMapping("/")
    String home(){
        return "Hello World";
    }

    public static void main(String[] args) {
        SpringApplication.run(QrCodeApplication.class, args);
    }

}
