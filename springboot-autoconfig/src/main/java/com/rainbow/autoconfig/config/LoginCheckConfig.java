package com.rainbow.autoconfig.config;


import com.rainbow.autoconfig.util.ReqInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginCheckConfig implements WebMvcConfigurer {
    // 此处代码指定哪些拦截器会生效
    @Autowired
    private ReqInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册一个 ReqInterceptor, 拦截除了 login 以外所有的请求
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
