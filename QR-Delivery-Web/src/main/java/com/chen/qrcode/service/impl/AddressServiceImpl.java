package com.chen.qrcode.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.qrcode.dao.AddressDao;
import com.chen.qrcode.dto.DeliveryDto;
import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressDao,AddressEntity> implements AddressService {
    @Resource
    AddressDao addressDao;

    @Override
    public List<AddressEntity> findAll() {
        Wrapper<AddressEntity> wrapper = new QueryWrapper<>();
        return addressDao.selectList(wrapper);
    }

    @Override
    public IPage<AddressEntity> findPage(int pageNums, int limit) {
        Wrapper<AddressEntity> wrapper = new QueryWrapper<>();
        Page<AddressEntity> page = new Page<>(pageNums,limit);
        return addressDao.selectPage(page,wrapper);
    }

    @Override
    public IPage<AddressEntity> findPage(int pageNums, int limit, String id, String name, String phone) {
        QueryWrapper<AddressEntity> wrapper = new QueryWrapper<>();
        if(id != null){
            wrapper.like("id", id); // 使用like方法进行模糊查询
        }
        if(phone!=null){
            wrapper.like("phone", name); // 使用like方法进行模糊查询
        }
        if(name!=null){
            wrapper.like("name", phone); // 使用like方法进行模糊查询
        }
        Page<AddressEntity> page = new Page<>(pageNums,limit);
        return addressDao.selectPage(page,wrapper);
    }

    public List<DeliveryDto> findById(List<DeliveryDto> deliveryDtos){
        for (DeliveryDto deliveryDto : deliveryDtos) {
            AddressEntity src = addressDao.selectById(deliveryDto.getSrcAddressId());
            deliveryDto.setSrcName(src.getName());
            deliveryDto.setSrcPhone(src.getPhone());
            deliveryDto.setSrcAddress(src.getAddress());
            AddressEntity dst = addressDao.selectById(deliveryDto.getDstAddressId());
            deliveryDto.setDstName(dst.getName());
            deliveryDto.setDstPhone(dst.getPhone());
            deliveryDto.setDstAddress(dst.getAddress());
        }
        return deliveryDtos;
    }
}
