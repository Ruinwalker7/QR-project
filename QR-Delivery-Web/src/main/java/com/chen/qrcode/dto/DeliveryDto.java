package com.chen.qrcode.dto;

import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.DeliveryEntity;
import lombok.Data;

@Data
public class DeliveryDto extends DeliveryEntity {

    private String srcName;

    private String srcPhone;

    private String srcAddress;

    private String dstName;

    private String dstPhone;

    private String dstAddress;

    private String username;

}
