package com.chen.qrcode.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chen.qrcode.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
}
