package com.chen.qrcode.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryDto {

    private Long id;

    private String srcName;

    private String srcPhone;

    private String srcAddress;

    private String dstName;

    private String dstPhone;

    private String dstAddress;

    private String status;

    private LocalDateTime createTime;

    private String username;

}
