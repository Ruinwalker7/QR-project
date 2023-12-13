package com.chen.qrcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//@SpringBootApplication
@SpringBootApplication //开启自动配置
@MapperScan(basePackages = "com.chen.qrcode.dao")
public class QrCodeApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(QrCodeApplication.class, args);
    }
}
