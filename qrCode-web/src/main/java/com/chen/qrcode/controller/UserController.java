package com.chen.qrcode.controller;

import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    String home(){
        return "Hello user!";
    }


    @RequestMapping("/getList")
    public List<UserEntity> getList(){
        List<UserEntity> userEntityList = userService.list();
        return userEntityList;
    }
}
