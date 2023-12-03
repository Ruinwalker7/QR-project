package com.chen.qrcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public/**").permitAll() // 公共资源放行
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll() // 登录页面
                .and()
                .logout().permitAll(); // 登出
    }
}
