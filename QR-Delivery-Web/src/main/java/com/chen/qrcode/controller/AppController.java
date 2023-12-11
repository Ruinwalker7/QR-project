package com.chen.qrcode.controller;

import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.DeliverymanDao;;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import com.chen.qrcode.utils.JsonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private DeliverymanServiceImpl deliverymanService;

    @Autowired
    private DeliverymanDao deliverymanDao;

    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    //App 登录控制
    @PostMapping("/login")
    public String login(@RequestBody DeliverymanEntity requestBody) {
        JsonResponse jsonResponse = new JsonResponse();
        DeliverymanEntity deliveryman = deliverymanService.authenticateUser(requestBody.getPhone(), requestBody.getPassword());
        if (deliveryman != null) {
            jsonResponse.setCode(ResConfig.Code.OK);
            jsonResponse.setMessage("");
            jsonResponse.setData(deliveryman);
        } else {
            jsonResponse.setCode(ResConfig.Code.USER_ERROR);
            jsonResponse.setMessage(ResConfig.Msg.LOGIN_ERROR);
            jsonResponse.setData("");
        }
        String json = "";
        try {
            json = objectMapper.writeValueAsString(jsonResponse);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return json;
        }
    }


    //App 注册控制
    @PostMapping("/registe")
    public ResponseEntity<String> register(@RequestBody DeliverymanEntity requestBody){
        int res = 0;
        try{
           res = deliverymanDao.insert(requestBody);
        }finally {
            if (res==1) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("身份证或手机号已经被注册");
            }
        }
    }
}
