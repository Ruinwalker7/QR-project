package com.chen.qrcode.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@TableName(value="deliveryman")
@Data
public class DeliverymanEntity {
    @TableId(type = IdType.NONE)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String workAddress;

    private String idCard;

    private Boolean visitSrc;

    private Boolean visitDst;

    private Boolean visitDelivery;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
