package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.qrcode.dao.CustomerDao;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.entity.CustomerEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON
    @GetMapping("/all")
    public String getAllDelivery( @RequestParam(name="page", defaultValue = "1") Integer pagenums,
                                  @RequestParam(defaultValue = "10") Integer limit,
                                  @RequestParam(name="username",required = false) String id,
                                  @RequestParam(name="phone",required = false) String src
                                 ) {
        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();

        if(id != null){
            queryWrapper.like("username", id); // 使用like方法进行模糊查询
        }
        if(src!=null){
            queryWrapper.like("phone", src); // 使用like方法进行模糊查询
        }


        Page<CustomerEntity> page = new Page<>(pagenums, limit);
        IPage<CustomerEntity> iPage =  customerDao.selectPage(page,queryWrapper);
        List<CustomerEntity> deliveryEntities = iPage.getRecords();

        System.out.println(deliveryEntities);

        try {
            return "{\"code\": 0,\"msg\": \"\",\n" +
                    "    \"count\": "+ iPage.getTotal()+",\n" +
                    "    \"totalRow\": {\n" +
                    "        \"era\": {\n" +
                    "            \"tang\": \"2\",\n" +
                    "            \"song\": \"2\",\n" +
                    "            \"xian\": \"20\"\n" +
                    "        }\n" +
                    "    },    \"data\": " + objectMapper.writeValueAsString(deliveryEntities) +"}";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id){
        System.out.println(id);
        int rowsAffected = customerDao.deleteById(id);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除失败");
        }
    }
}
