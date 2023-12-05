package com.chen.qrcode.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;

import java.time.LocalDateTime;

@TableName(value="delivery")
@Data
public class DeliveryEntity {
    @TableId(type = IdType.NONE)
    private Long id;

    private String srcName;

    private String srcPhone;

    private String srcAddress;

    private String dstName;

    private String dstPhone;

    private String dstAddress;

    private String status;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
