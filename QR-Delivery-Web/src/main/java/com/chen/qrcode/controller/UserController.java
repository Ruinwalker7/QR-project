package com.chen.qrcode.controller;

import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.UserService;
import com.chen.qrcode.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    String home(){
        return "Hello user!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserEntity requestBody) {
        boolean isAuthenticated = userService.authenticateUser(requestBody.getUsername(), requestBody.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
        // 在这里进行验证逻辑，比如检查用户名密码是否匹配数据库中的记录
        // 假设验证成功，返回一些数据给前端
    }

    @RequestMapping("/getList")
    public List<UserEntity> getList(){
        List<UserEntity> userEntityList = userService.list();
        return userEntityList;
    }
}