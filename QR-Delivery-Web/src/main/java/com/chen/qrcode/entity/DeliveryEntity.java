package com.chen.qrcode.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@TableName(value="delivery")
@Data
public class DeliveryEntity {
    @TableId(type = IdType.NONE)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private long srcAddressId;

    private long dstAddressId;

    private String status;

    private String type;

    private Long deliverymanId;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField (exist = false)
    private DeliverymanEntity deliveryman;
}
