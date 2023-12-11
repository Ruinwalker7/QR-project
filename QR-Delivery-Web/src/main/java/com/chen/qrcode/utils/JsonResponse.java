package com.chen.qrcode.utils;

public class JsonResponse {
    private int code;
    private String message;
    private Object data;

    // 构造函数和getter/setter方法省略

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

