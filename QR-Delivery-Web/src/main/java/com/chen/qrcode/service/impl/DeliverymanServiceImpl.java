package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.DeliveryService;
import com.chen.qrcode.service.DeliverymanService;
import org.springframework.stereotype.Service;

@Service
public class DeliverymanServiceImpl extends ServiceImpl<DeliverymanDao, DeliverymanEntity> implements DeliverymanService {
}
