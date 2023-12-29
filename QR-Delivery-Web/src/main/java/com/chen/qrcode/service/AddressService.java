package com.chen.qrcode.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.qrcode.entity.AddressEntity;

import java.util.List;

public interface AddressService extends IService<AddressEntity> {
    List<AddressEntity> findAll();
    IPage<AddressEntity> findPage(int pageNums, int limit);
    IPage<AddressEntity> findPage(int pageNums, int limit, String id,  String name,  String phone);
}
