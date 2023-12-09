package com.chen.qrcode.controller;

import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.UserService;
import com.chen.qrcode.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
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


    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, @RequestBody UserEntity requestBody) {
        boolean isAuthenticated = userService.authenticateUser(requestBody.getUsername(), requestBody.getPassword());
        if (isAuthenticated) {
            session.setAttribute("loggedIn", true);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

//    @RequestMapping("/getList")
//    public List<UserEntity> getList(){
//        List<UserEntity> userEntityList = userService.list();
//        return userEntityList;
//    }
}
