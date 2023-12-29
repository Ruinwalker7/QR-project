package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.service.impl.AddressServiceImpl;
import com.chen.qrcode.utils.JsonResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    AddressServiceImpl addressService;

    @Resource
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @GetMapping("/all")
    public String all(@RequestParam(name="page", defaultValue = "1") Integer pageNums,
                      @RequestParam(defaultValue = "10") Integer limit,
                      @RequestParam(name="id",required = false) String id,
                      @RequestParam(name="name",required = false) String name,
                      @RequestParam(name="phone",required = false) String phone)  {
        IPage<AddressEntity> page =  addressService.findPage(pageNums,limit,id,name,phone);
        List<AddressEntity> addressEntityList = page.getRecords();
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(ResConfig.Code.OK);
        jsonResponse.setCount(page.getTotal());
        jsonResponse.setData(addressEntityList);
        String json = null;
        try{
            json = objectMapper.writeValueAsString(jsonResponse);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
