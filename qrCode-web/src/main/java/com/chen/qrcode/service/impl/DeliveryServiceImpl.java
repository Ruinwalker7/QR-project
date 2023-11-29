package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.service.DeliveryService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryDao,DeliveryEntity> implements DeliveryService {
}
