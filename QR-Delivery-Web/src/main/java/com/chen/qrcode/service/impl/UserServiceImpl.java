package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.UserDao;
import com.chen.qrcode.entity.UserEntity;
import com.chen.qrcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
    @Autowired
    private UserDao userDao;

    public UserEntity findByUsername(String username) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userDao.selectOne(queryWrapper);
    }

    public boolean authenticateUser(String username, String password) {
        UserEntity user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 用户名和密码验证成功
            return true;
        }
        // 验证失败
        return false;
    }
}
