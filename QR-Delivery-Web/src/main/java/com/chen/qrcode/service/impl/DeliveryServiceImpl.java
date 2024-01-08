package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.config.JsonResponse;
import com.chen.qrcode.config.ResConfig;
import com.chen.qrcode.dao.AddressDao;
import com.chen.qrcode.dao.DeliveryDao;
import com.chen.qrcode.dto.DeliveryDetail;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.DeliveryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryDao,DeliveryEntity> implements DeliveryService {
    @Resource
    private DeliveryDao deliveryDao;
    @Resource
    private AddressDao addressDao;

    @Override
    public IPage<DeliveryDto> findPage(int pageNums, int limit, String id) {
        QueryWrapper<DeliveryDto> wrapper = new QueryWrapper<>();
        if (id != null) {
            wrapper.like("delivery.id", id); // 使用like方法进行模糊查询
        }
        Page<DeliveryDto> page = new Page<>(pageNums, limit);
        return deliveryDao.selectAllDto(page, wrapper);
    }

    @Override
    public DeliveryDetail findDetail(long id) {
        DeliveryEntity deliveryEntity = deliveryDao.selectById(id);
        if (deliveryEntity == null) {
            return null;
        }
        AddressEntity addressSrc = addressDao.selectById(deliveryEntity.getSrcAddressId());
        AddressEntity addressDst = addressDao.selectById(deliveryEntity.getDstAddressId());
        DeliveryDetail deliveryDetail = new DeliveryDetail(deliveryEntity, addressSrc, addressDst);
        return deliveryDetail;
    }
}
