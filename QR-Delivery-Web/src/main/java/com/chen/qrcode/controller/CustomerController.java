package com.chen.qrcode.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chen.qrcode.dao.CustomerDao;
import com.chen.qrcode.entity.CustomerEntity;
import com.chen.qrcode.service.impl.CustomerServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @GetMapping("/all")
    public String getAllDelivery(@RequestParam(name = "page", defaultValue = "1") Integer pageNums, @RequestParam(defaultValue = "10") Integer limit, @RequestParam(name = "username", required = false) String id, @RequestParam(name = "phone", required = false) String phone) {
        IPage<CustomerEntity> iPage = customerService.findAll(pageNums, limit, id, phone);
        List<CustomerEntity> deliveryEntities = iPage.getRecords();
        System.out.println(deliveryEntities);

        try {
            return "{\"code\": 0,\"msg\": \"\",\n" + "    \"count\": " + iPage.getTotal() + ",\n" + "    \"data\": " + objectMapper.writeValueAsString(deliveryEntities) + "}";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        System.out.println(id);
        int rowsAffected = customerDao.deleteById(id);
        if (rowsAffected > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除失败");
        }
    }
}
