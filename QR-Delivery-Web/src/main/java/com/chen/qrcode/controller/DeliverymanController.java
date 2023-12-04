package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.impl.DeliverymanServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/man")
public class DeliverymanController {

    @Autowired
    private DeliverymanDao deliverymanDao;
    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @GetMapping("/all")
    public String getAllUsers( @RequestParam(name="page", defaultValue = "1") Integer pagenums,
                               @RequestParam(defaultValue = "10") Integer limit) {
        System.out.println(pagenums);
        System.out.println(limit);
        Page<DeliverymanEntity> page = new Page<>(pagenums, limit);
        IPage<DeliverymanEntity> iPage =  deliverymanDao.selectPage(page, null);
        List<DeliverymanEntity> deliverymanEntities = iPage.getRecords();

        System.out.println(deliverymanEntities);

        try {
            System.out.println(objectMapper.writeValueAsString(deliverymanEntities));
            return "{\"code\": 0,\"msg\": \"\",\n" +
                    "    \"count\": "+ iPage.getTotal()+",\n" +
                    "    \"totalRow\": {\n" +
                    "        \"era\": {\n" +
                    "            \"tang\": \"2\",\n" +
                    "            \"song\": \"2\",\n" +
                    "            \"xian\": \"20\"\n" +
                    "        }\n" +
                    "    },    \"data\": " + objectMapper.writeValueAsString(deliverymanEntities) +"}";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }

//        return deliverymanDao.selectList(null); // 通过selectList查询所有用户数据
    }

}
