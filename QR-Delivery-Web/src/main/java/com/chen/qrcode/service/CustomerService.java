package com.chen.qrcode.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.qrcode.entity.CustomerEntity;

import java.util.List;

public interface CustomerService extends IService<CustomerEntity> {
    List<CustomerEntity> findAll();
    IPage<CustomerEntity> findAll(int pageNums, int limit, String id, String phone);
}
