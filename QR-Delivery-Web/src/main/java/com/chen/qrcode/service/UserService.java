package com.chen.qrcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chen.qrcode.entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    UserEntity findByUsername(String username);
    boolean authenticateUser(String username, String password);
}
