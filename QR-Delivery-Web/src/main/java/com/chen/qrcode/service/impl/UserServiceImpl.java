package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public UserEntity findByUsername(String username) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userDao.selectOne(queryWrapper);
    }
    @Override
    public boolean authenticateUser(String username, String password) {
        UserEntity user = findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
