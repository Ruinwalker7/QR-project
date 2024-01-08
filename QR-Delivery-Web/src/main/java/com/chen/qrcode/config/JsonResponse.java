package com.chen.qrcode.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResponse implements Serializable {

    private int code;

    private String message;

    private Object data;

    private long count;
}

