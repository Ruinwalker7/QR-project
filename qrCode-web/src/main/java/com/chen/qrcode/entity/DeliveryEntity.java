package com.chen.qrcode.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Value;

@TableName(value="delivery")
@Data
public class DeliveryEntity {
    @TableId(type = IdType.NONE)
    private Long id;

    private String username;

    private String password;

    private String phone;
}
