package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.config.JsonResponse;
import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.dto.DeliveryDetail;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.DeliveryService;
import com.chen.qrcode.service.DeliverymanService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverymanServiceImpl extends ServiceImpl<DeliverymanDao, DeliverymanEntity> implements DeliverymanService {
    @Autowired
    private DeliverymanDao deliverymanDao;

    public DeliverymanEntity findByUsername(String username) {
        QueryWrapper<DeliverymanEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", username);
        return deliverymanDao.selectOne(queryWrapper);
    }

    public DeliverymanEntity authenticateUser(String username, String password) {
        DeliverymanEntity user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /**
     * 查询快递详情
     * @param detail 快递详情
     * @param phone 手机号
     * @return
     */
    public DeliveryDetail getDelivery(DeliveryDetail detail,String phone){
        if (detail == null){
            return null;
        }
        DeliverymanEntity deliveryman = deliverymanDao.selectByPhone(phone);

        if(detail.getDeliverymanId() != deliveryman.getId()){
            return null;
        }

        if(!deliveryman.getVisitDst())
        {
            detail.setDstAddress("");
            detail.setDstPhone("");
            detail.setDstName("");
        }
        if(!deliveryman.getVisitSrc()){
            detail.setSrcAddress("");
            detail.setSrcPhone("");
            detail.setSrcName("");
        }
        if(!deliveryman.getVisitDelivery()){
            detail.setType("");
        }
        return detail;
    }
}
