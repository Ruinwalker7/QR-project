package com.chen.qrcode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.qrcode.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {
}
