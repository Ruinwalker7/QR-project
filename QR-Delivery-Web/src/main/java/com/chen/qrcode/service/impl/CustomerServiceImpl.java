package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.CustomerDao;
import com.chen.qrcode.dao.DeliverymanDao;
import com.chen.qrcode.entity.CustomerEntity;
import com.chen.qrcode.entity.DeliverymanEntity;
import com.chen.qrcode.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerDao, CustomerEntity> implements CustomerService {
    @Resource
    private CustomerDao customerDao;

    @Autowired
    private DeliverymanDao deliverymanDao;

    public CustomerEntity findByUsername(String username) {
        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", username);
        return customerDao.selectOne(queryWrapper);
    }

    public CustomerEntity authenticateUser(String username, String password) {
        CustomerEntity user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public List<CustomerEntity> findAll(){
        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();
        return customerDao.selectList(queryWrapper);
    }

    @Override
    public  IPage<CustomerEntity> findAll(int pageNums, int limit, String id,String phone){
        QueryWrapper<CustomerEntity> queryWrapper = new QueryWrapper<>();
        if(id != null){
            queryWrapper.like("username", id); // 使用like方法进行模糊查询
        }
        if(phone!=null){
            queryWrapper.like("phone", phone); // 使用like方法进行模糊查询
        }
        Page<CustomerEntity> page = new Page<>(pageNums, limit);
        return customerDao.selectPage(page,queryWrapper);
    }
}
