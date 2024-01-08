package com.chen.qrcode.dto;

import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.DeliveryEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryDetail {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String srcName;

    private String srcPhone;

    private String srcAddress;

    private String dstName;

    private String dstPhone;

    private String dstAddress;

    private String status;

    private String type;

    private long deliverymanId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public DeliveryDetail(DeliveryEntity deliveryEntity, AddressEntity addressSrc,AddressEntity addressDst){
        id = deliveryEntity.getId();
        srcName = addressSrc.getName();
        srcAddress = addressSrc.getAddress();
        srcPhone = addressSrc.getPhone();
        dstAddress = addressDst.getAddress();
        dstName = addressDst.getName();
        dstPhone = addressDst.getPhone();
        createTime = deliveryEntity.getCreateTime();
        updateTime = deliveryEntity.getUpdateTime();
        deliverymanId = deliveryEntity.getDeliverymanId();
        status = deliveryEntity.getStatus();
        type = deliveryEntity.getType();
    }
}
