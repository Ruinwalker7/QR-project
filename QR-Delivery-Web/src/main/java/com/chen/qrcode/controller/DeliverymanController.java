package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@RequestMapping("/api/man")
public class DeliverymanController {

    @Autowired
    private DeliverymanDao deliverymanDao;
    @Autowired
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody DeliverymanEntity deliverymanEntity){
        int rowsAffected = deliverymanDao.updateById(deliverymanEntity);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id){
        System.out.println(id);
        int rowsAffected = deliverymanDao.deleteById(id);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除失败");
        }
    }

    @GetMapping("/update/src")
    public ResponseEntity<String> updateSrc(@RequestParam String id, @RequestParam boolean value){
        DeliverymanEntity deliveryman = deliverymanDao.selectById(id);
        deliveryman.setVisitSrc(value);
        int rowsAffected = deliverymanDao.updateById(deliveryman);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }

    @GetMapping("/update/dst")
    public ResponseEntity<String> updateDst(@RequestParam String id, @RequestParam boolean value){
        DeliverymanEntity deliveryman = deliverymanDao.selectById(id);
        deliveryman.setVisitDst(value);
        int rowsAffected = deliverymanDao.updateById(deliveryman);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }


    @GetMapping("/update/delivery")
    public ResponseEntity<String> updateDelivery(@RequestParam String id, @RequestParam boolean value){
        DeliverymanEntity deliveryman = deliverymanDao.selectById(id);
        deliveryman.setVisitDelivery(value);
        int rowsAffected = deliverymanDao.updateById(deliveryman);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }
    @GetMapping("/all")
    public String getAllUsers( @RequestParam(name="page", defaultValue = "1") Integer pagenums,
                               @RequestParam(defaultValue = "10") Integer limit,
                               @RequestParam(name="ID",required = false) String id,
                               @RequestParam(name="username",required = false) String username,
                               @RequestParam(name="ID_card",required = false) String idcard ) {
        QueryWrapper<DeliverymanEntity> queryWrapper = new QueryWrapper<>();
        if(id != null){
            queryWrapper.like("id", id); // 使用like方法进行模糊查询
        }
        if(username!=null){
            queryWrapper.like("username", username); // 使用like方法进行模糊查询
        }
        if(idcard!=null){
            queryWrapper.like("id_card", idcard); // 使用like方法进行模糊查询
        }

        Page<DeliverymanEntity> page = new Page<>(pagenums, limit);
        IPage<DeliverymanEntity> iPage =  deliverymanDao.selectPage(page, queryWrapper);
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

    }

}
