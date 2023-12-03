package com.chen.qrcode.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value="deliveryman")
@Data
public class DeliverymanEntity {
    @TableId(type = IdType.NONE)
    private Long id;

    private String username;

    private String password;

    private String phone;


}