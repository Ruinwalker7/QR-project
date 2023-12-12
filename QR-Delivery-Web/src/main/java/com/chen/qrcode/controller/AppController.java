package com.chen.qrcode.controller;

import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dao.DeliverymanDao;;
import com.chen.qrcode.dto.DeliveryIdDto;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import com.chen.qrcode.utils.JsonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.exceptions.SQLError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private DeliverymanServiceImpl deliverymanService;

    @Autowired
    private DeliverymanDao deliverymanDao;

    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @Autowired
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
    public String register(@RequestBody DeliverymanEntity requestBody){
        JsonResponse jsonResponse = new JsonResponse();
        int res=0;
        try{
            res = deliverymanDao.insert(requestBody);
        }finally {
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
            finally {
                return json;
            }
        }
    }

    @GetMapping("/alldelivery")
    public String getDelierybyphone(@RequestParam String phone){
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
        finally {
            return json;
        }
    }

    @GetMapping("/deliverydetail")
    public String getDelieryDetail(@RequestParam String phone, @RequestParam String id){
        DeliveryEntity deliveryEntity = deliveryDao.selectById(id);
        DeliverymanEntity deliveryman = deliverymanDao.selectByPhone(phone);
        JsonResponse jsonResponse = new JsonResponse();
        if (deliveryEntity == null){
            jsonResponse.setCode(ResConfig.Code.FAILURE);
            jsonResponse.setData("");
            jsonResponse.setMessage(ResConfig.Msg.INPUT_ERROR);
        }
        else if(deliveryEntity.getDeliverymanId() != deliveryman.getId()){
            jsonResponse.setCode(ResConfig.Code.NO_AUTH);
            jsonResponse.setData("");
            jsonResponse.setMessage(ResConfig.Msg.AUTH_ERROR);
        }else{
            if(!deliveryman.getVisitDst()){
                deliveryEntity.setDstAddress("");
                deliveryEntity.setDstPhone("");
                deliveryEntity.setDstName("");

            }
            if(!deliveryman.getVisitSrc()){
                deliveryEntity.setSrcAddress("");
                deliveryEntity.setSrcPhone("");
                deliveryEntity.setSrcName("");

            }
            if(!deliveryman.getVisitDelivery()){
                deliveryEntity.setName("");
                deliveryEntity.setType("");
            }
            jsonResponse.setCode(ResConfig.Code.OK);
            jsonResponse.setData(deliveryEntity);
            jsonResponse.setMessage("");
        }
        String json = "";
        try {
            json = objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        finally {
            return json;
        }
    }
}
