package com.chen.qrcode.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.entity.DeliveryEntity;

public interface DeliveryService extends IService<DeliveryEntity> {
    IPage<DeliveryDto> findPage(int pageNums, int limit, String id);

}
