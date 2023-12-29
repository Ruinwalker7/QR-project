package com.chen.qrcode.dto;

import com.chen.qrcode.entity.AddressEntity;
import com.chen.qrcode.entity.DeliveryEntity;
import lombok.Data;

@Data
public class DeliveryDto extends DeliveryEntity {

    private AddressEntity srcInfo;

    private AddressEntity dstInfo;

}
