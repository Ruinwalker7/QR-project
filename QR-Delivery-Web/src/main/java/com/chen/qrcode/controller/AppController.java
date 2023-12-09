package com.chen.qrcode.controller;

import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private DeliverymanServiceImpl deliverymanService;

    @Autowired
    private DeliverymanDao deliverymanDao;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DeliverymanEntity requestBody){
        boolean isAuthenticated = deliverymanService.authenticateUser(requestBody.getPhone(), requestBody.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/registe")
    public ResponseEntity<String> register(@RequestBody DeliverymanEntity requestBody){
        int res = 0;
        try{
           res = deliverymanDao.insert(requestBody);
        }finally {
            System.out.println(res);
            if (res==1) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("身份证或手机号已经被注册");
            }
        }
    }
}
