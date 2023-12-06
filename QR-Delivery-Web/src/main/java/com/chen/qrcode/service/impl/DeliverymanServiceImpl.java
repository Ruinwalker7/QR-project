package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.DeliveryService;
import com.chen.qrcode.service.DeliverymanService;
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

    public boolean authenticateUser(String username, String password) {
        DeliverymanEntity user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 用户名和密码验证成功
            return true;
        }
        // 验证失败
        return false;
    }
}
