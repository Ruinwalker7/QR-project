package com.chen.qrcode.controller;

import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dto.DeliveryIdDto;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import com.chen.qrcode.utils.JsonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/app")
public class AppController {
    @Resource
    private DeliverymanServiceImpl deliverymanService;

    @Resource
    private DeliverymanDao deliverymanDao;

    @Resource
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @Resource
    private DeliveryDao deliveryDao;
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
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    //App 注册控制
    @PostMapping("/registe")
    public String register(@RequestBody DeliverymanEntity requestBody){
        JsonResponse jsonResponse = new JsonResponse();
        requestBody.setVisitDst(false);
        requestBody.setVisitSrc(false);
        requestBody.setVisitDelivery(false);
        requestBody.setIdCard("待设置");
        requestBody.setWorkAddress("待设置");
        int res = deliverymanDao.insert(requestBody);
        if (res != 0) {
            jsonResponse.setCode(ResConfig.Code.OK);
            jsonResponse.setMessage("");
            jsonResponse.setData("");
        } else {
            jsonResponse.setCode(ResConfig.Code.EXISTS);
            jsonResponse.setMessage(ResConfig.Msg.EXIST_ERROR);
            jsonResponse.setData("");
        }
        String json = "";
        try {
            json = objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    @GetMapping("/alldelivery")
    public String getDeliveryByPhone(@RequestParam String phone){
        JsonResponse jsonResponse = new JsonResponse();
        List<DeliveryIdDto> deliveryEntities= deliveryDao.selectName(phone);
        jsonResponse.setCode(ResConfig.Code.OK);
        jsonResponse.setMessage("");
        jsonResponse.setData(deliveryEntities);
        String json = "";
        try {
            json = objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
