package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.qrcode.config.JsonResponse;
import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.AddressDao;
import com.chen.qrcode.dao.CustomerDao;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dto.DeliveryDetail;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.dto.DeliveryIdDto;
import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.CustomerEntity;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.impl.CustomerServiceImpl;
import com.chen.qrcode.service.impl.DeliveryServiceImpl;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/app/customer")
public class AppCustomerControlller {
    @Resource
    private CustomerDao customerDao;
    @Resource
    private DeliverymanServiceImpl deliverymanService;

    @Resource
    private CustomerServiceImpl customerService;

    @Resource
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @Resource
    private DeliveryDao deliveryDao;

    @Resource
    private DeliveryServiceImpl deliveryService;

    @Resource
    private AddressDao addressDao;
    private JsonResponse jsonResponse = new JsonResponse();


    @GetMapping("/address")
    public String getAddreess(@RequestParam long id){
        QueryWrapper<AddressEntity> queryWrapper = new QueryWrapper<>();


        queryWrapper.eq("customer_id", id); // 使用like方法进行模糊查询
        List<AddressEntity> addressEntities = addressDao.selectList(queryWrapper);

        System.out.println(addressEntities);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(ResConfig.Code.OK);
        jsonResponse.setData(addressEntities);

        try {
            return objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }
    /**
     * APP登录
     * @param requestBody 用户名密码
     * @return Response
     */
    @PostMapping("/login")
    public String login(@RequestBody CustomerEntity requestBody) {
        CustomerEntity deliveryman = customerService.authenticateUser(requestBody.getPhone(), requestBody.getPassword());
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
    public String register(@RequestBody CustomerEntity requestBody){

        int res = customerDao.insert(requestBody);
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
    @GetMapping("/senddelivery")
    public String getDeliveryByPhone(@RequestParam String phone){
        List<DeliveryIdDto> deliveryEntities= deliveryDao.selectSend(phone);
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

    @GetMapping("/receivedelivery")
    public String getReceiveDeliveryByPhone(@RequestParam String phone){
        List<DeliveryIdDto> deliveryEntities= deliveryDao.selectReceive(phone);
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
        if(deliveryDetail == null){
            jsonResponse.setCode(ResConfig.Code.FAILURE);
            jsonResponse.setData("");
            jsonResponse.setMessage(ResConfig.Msg.INPUT_ERROR);
        }
        else if(Objects.equals(deliveryDetail.getSrcPhone(), phone) || Objects.equals(deliveryDetail.getDstPhone(), phone)){
            jsonResponse.setCode(ResConfig.Code.OK);
            jsonResponse.setData(deliveryDetail);
            jsonResponse.setMessage("");
        }else{
            jsonResponse.setCode(ResConfig.Code.NO_AUTH);
            jsonResponse.setData("");
            jsonResponse.setMessage(ResConfig.Msg.AUTH_ERROR);
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

    @PostMapping("/saveaddress")
    public String getDeliveryDetail(@RequestBody AddressEntity address){

        int res = addressDao.insert(address);;
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

    @PostMapping("/adddelivery")
    public String insertDelivery(@RequestBody DeliveryEntity deliveryEntity){
        deliveryEntity.setDeliverymanId(null);
        int res = deliveryDao.insert(deliveryEntity);;
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
}
