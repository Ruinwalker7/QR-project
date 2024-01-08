package com.chen.qrcode.controller;

import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.AddressDao;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dto.DeliveryDetail;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.dto.DeliveryIdDto;
import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.DeliveryService;
import com.chen.qrcode.service.impl.DeliveryServiceImpl;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import com.chen.qrcode.config.JsonResponse;
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

    @Resource
    private AddressDao addressDao;

    @Resource
    private DeliveryServiceImpl deliveryService;

    private JsonResponse jsonResponse = new JsonResponse();
    /**
     * APP登录
     * @param requestBody 用户名密码
     * @return Response
     */
    @PostMapping("/login")
    public String login(@RequestBody DeliverymanEntity requestBody) {
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


    /**
     * APP注册
     * @param requestBody 用户名密码手机号等
     * @return response
     */
    @PostMapping("/registe")
    public String register(@RequestBody DeliverymanEntity requestBody){
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


    /**
     * 查询所有快递
     * @param phone 手机号
     * @return 快递集合
     */
    @GetMapping("/alldelivery")
    public String getDeliveryByPhone(@RequestParam String phone){
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

    /**
     * 查询快递详情
     * @param phone 快递员手机号
     * @param id 快递员ID
     * @return
     */
    @GetMapping("/deliverydetail")
    public String getDeliveryDetail(@RequestParam String phone, @RequestParam long id){

        DeliveryDetail deliveryDetail = deliveryService.findDetail(id);
        DeliveryDetail detail = deliverymanService.getDelivery(deliveryDetail,phone);

        if(deliveryDetail == null){
            jsonResponse.setCode(ResConfig.Code.FAILURE);
            jsonResponse.setData("");
            jsonResponse.setMessage(ResConfig.Msg.INPUT_ERROR);
        }
        else if(detail == null){
            jsonResponse.setCode(ResConfig.Code.NO_AUTH);
            jsonResponse.setData("");
            jsonResponse.setMessage(ResConfig.Msg.AUTH_ERROR);
        }else{
            jsonResponse.setCode(ResConfig.Code.OK);
            jsonResponse.setData(detail);
            jsonResponse.setMessage("");
        }
        String json = "";
        try {
            json = objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(json);
        return json;
    }
}
