package com.example.mytlias.config;

import com.example.mytlias.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginCheckConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor interceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截除了 login 以外的所有请求
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
