package com.chen.qrcode.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.dto.DeliverymanNameDto;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.impl.AddressServiceImpl;
import com.chen.qrcode.service.impl.DeliveryServiceImpl;
import com.chen.qrcode.config.JsonResponse;
import com.chen.qrcode.utils.QRCodeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
@Slf4j
public class DeliveryConroller {
    @Resource
    private DeliveryDao deliveryDao;

    @Resource
    private DeliverymanDao deliverymanDao;

    @Resource
    private ObjectMapper objectMapper; // 使用Jackson ObjectMapper将对象转换为JSON

    @Resource
    private DeliveryServiceImpl deliveryService;

    @Resource
    private AddressServiceImpl addressService;
    @PostMapping("/update/allot")
    public ResponseEntity<String> updateAllot(@RequestParam("id") long id, @RequestParam("deliverymanid") String deliverymanid){
        System.out.println(deliverymanid);
        DeliveryEntity deliveryEntity = deliveryDao.selectById(id);
        DeliverymanEntity deliveryman = deliverymanDao.selectByPhone(deliverymanid);
        deliveryEntity.setDeliverymanId(deliveryman.getId());
        int rowsAffected = deliveryDao.updateById(deliveryEntity);
        if (rowsAffected > 0) {
            return  ResponseEntity.status(HttpStatus.OK).body("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失败");
        }
    }


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
        int rowsAffected = deliveryDao.deleteById(id);
        if (rowsAffected > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("删除失败");
        }
    }

    @PostMapping("/name")
    public String getName()  {
        List<DeliverymanNameDto> man = deliverymanDao.selectName();
        try {
            return objectMapper.writeValueAsString(man) ;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }

    @GetMapping("/all")
    public String getAllDelivery( @RequestParam(name="page", defaultValue = "1") Integer pageNums,
                               @RequestParam(defaultValue = "10") Integer limit,
                                  @RequestParam(name="ID",required = false) String id,
                                  @RequestParam(name="phone",required = false) String phone) {
        IPage<DeliveryDto> deliveryDtoIPage = deliveryService.findPage(pageNums,limit,id);
        List<DeliveryDto> deliveryDtos = addressService.findById(deliveryDtoIPage.getRecords());

        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(ResConfig.Code.OK);
        jsonResponse.setData(deliveryDtos);
        jsonResponse.setCount(deliveryDtoIPage.getTotal());
        System.out.println(deliveryDtos);

        try {
            return objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }

    @GetMapping("/alloted")
    public String getAlloted( @RequestParam(name="page", defaultValue = "1") Integer pagenums,
                               @RequestParam(defaultValue = "10") Integer limit,
                               @RequestParam(name="ID",required = false) String id,
                               @RequestParam(name="srcName",required = false) String src,
                               @RequestParam(name="dstName",required = false) String dst ) {
        QueryWrapper<DeliveryDto> queryWrapper = new QueryWrapper<>();

        if(id != null){
            queryWrapper.like("delivery.id", id); // 使用like方法进行模糊查询
        }
        if(src!=null){
            queryWrapper.like("delivery.src_name", src); // 使用like方法进行模糊查询
        }
        if(dst!=null){
            queryWrapper.like("delivery.dst_name", dst); // 使用like方法进行模糊查询
        }

        Page<DeliveryDto> page = new Page<>(pagenums, limit);
        IPage<DeliveryDto> iPage =  deliveryDao.selectAllotedDto(page,queryWrapper);
        List<DeliveryDto> deliveryDtos = addressService.findById(iPage.getRecords());

        System.out.println(deliveryDtos);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(ResConfig.Code.OK);
        jsonResponse.setCount(iPage.getTotal());
        jsonResponse.setData(deliveryDtos);
        try {
            return  objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }

    @GetMapping("/unalloted")
    public String getUnalloted( @RequestParam(name="page", defaultValue = "1") Integer pagenums,
                              @RequestParam(defaultValue = "10") Integer limit,
                              @RequestParam(name="ID",required = false) String id,
                              @RequestParam(name="srcName",required = false) String src,
                              @RequestParam(name="dstName",required = false) String dst ) {
        QueryWrapper<DeliveryDto> queryWrapper = new QueryWrapper<>();

        if(id != null){
            queryWrapper.like("delivery.id", id); // 使用like方法进行模糊查询
        }
        if(src!=null){
            queryWrapper.like("delivery.src_name", src); // 使用like方法进行模糊查询
        }
        if(dst!=null){
            queryWrapper.like("delivery.dst_name", dst); // 使用like方法进行模糊查询
        }
        queryWrapper.isNull("delivery.deliveryman_id");

        Page<DeliveryDto> page = new Page<>(pagenums, limit);
        IPage<DeliveryDto> iPage =  deliveryDao.selectUnAllotedDto(page,queryWrapper);
        List<DeliveryDto> deliveryDtos = addressService.findById(iPage.getRecords());
        System.out.println(deliveryDtos);
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setCode(ResConfig.Code.OK);
        jsonResponse.setCount(iPage.getTotal());
        jsonResponse.setData(deliveryDtos);

        try {
            return objectMapper.writeValueAsString(jsonResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }

    @GetMapping("/code")
    public ResponseEntity<byte[]> methodOne(@RequestParam String id) {
        byte[] qrCode = null;
        try {
            qrCode = QRCodeUtil.generateQrCodeByte(id, 350, 350);
        } catch (Exception e) {
            log.info("Exception:{}", e.getMessage());
        }
        // Header设置文件类型（对于ResponseEntity响应的方式，必须设置文件类型）
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(qrCode, headers, HttpStatus.CREATED);
    }

}
