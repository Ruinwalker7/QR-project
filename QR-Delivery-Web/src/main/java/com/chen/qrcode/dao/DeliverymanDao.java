package com.chen.qrcode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.dto.DeliverymanNameDto;
import com.chen.qrcode.entity.DeliveryEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeliverymanDao extends BaseMapper<DeliverymanEntity> {

    @Select("select  id,username as title from deliveryman " )
    List<DeliverymanNameDto>  selectName();

    @Select("select * from deliveryman where phone = ${phone} " )
    DeliverymanEntity selectByPhone(String phone);
}
