package com.chen.qrcode.controller;

import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private DeliverymanServiceImpl deliverymanService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DeliverymanEntity requestBody){
        boolean isAuthenticated = deliverymanService.authenticateUser(requestBody.getPhone(), requestBody.getPassword());
        if (isAuthenticated) {
//            session.setAttribute("loggedIn", true);
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

    }
}
