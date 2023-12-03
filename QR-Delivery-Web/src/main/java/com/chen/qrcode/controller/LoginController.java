package com.chen.qrcode.controller;

import com.chen.qrcode.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

//    @PostMapping("/user/login")
//    public String login(@RequestBody UserEntity requestBody) {
//        // 假设LoginForm类包含了前端表单中的用户名和密码字段
//        String name = requestBody.getUsername();
//        System.out.println(name);
////        System.out.println(password);
//        // 在这里进行验证逻辑，比如检查用户名密码是否匹配数据库中的记录
//        // 假设验证成功，返回一些数据给前端
//        return "{\"message\": \"Login successful\"}";
//    }
}