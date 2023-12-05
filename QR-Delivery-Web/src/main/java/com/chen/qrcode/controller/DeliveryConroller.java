package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryConroller {
    @Autowired
    private DeliveryDao deliveryDao;
    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody DeliveryEntity deliveryEntity){
        int rowsAffected = deliveryDao.updateById(deliveryEntity);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id){
        System.out.println(id);
        int rowsAffected = deliveryDao.deleteById(id);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除失败");
        }
    }

    @GetMapping("/all")
    public String getAllUsers( @RequestParam(name="page", defaultValue = "1") Integer pagenums,
                               @RequestParam(defaultValue = "10") Integer limit,
                               @RequestParam(name="ID",required = false) String id,
                               @RequestParam(name="srcName",required = false) String src,
                               @RequestParam(name="dstName",required = false) String dst ) {
        QueryWrapper<DeliveryEntity> queryWrapper = new QueryWrapper<>();
        if(id != null){
            queryWrapper.like("id", id); // 使用like方法进行模糊查询
        }
        if(src!=null){
            queryWrapper.like("src_name", src); // 使用like方法进行模糊查询
        }
        if(dst!=null){
            queryWrapper.like("dst_name", dst); // 使用like方法进行模糊查询
        }

        Page<DeliveryEntity> page = new Page<>(pagenums, limit);
        IPage<DeliveryEntity> iPage =  deliveryDao.selectPage(page, queryWrapper);
        List<DeliveryEntity> deliveryEntities = iPage.getRecords();

        System.out.println(deliveryEntities);

        try {
            System.out.println(objectMapper.writeValueAsString(deliveryEntities));
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
}
