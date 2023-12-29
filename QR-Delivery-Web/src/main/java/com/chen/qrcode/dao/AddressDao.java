package com.chen.qrcode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.qrcode.entity.AddressEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao extends BaseMapper<AddressEntity> {
}
