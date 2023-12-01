package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

}
