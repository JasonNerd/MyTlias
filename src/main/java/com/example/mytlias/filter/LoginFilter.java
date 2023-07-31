package com.example.mytlias.filter;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.example.mytlias.pojo.Result;
import com.example.mytlias.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

// servlet 注解, servlet 属于 JavaWeb 要素, 但并非 SpringBoot 组件, 因此需要在 Application 添加 servlet 支持
@Slf4j
@WebFilter("/*")
public class LoginFilter implements Filter {
    // 初始化方法, 只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化方法 ...");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 获取请求的资源路径(url)
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String url = req.getRequestURL().toString();
        // 1-1. 提前准备失败时需要写入的信息, 注意必须是 json 格式的字符串
        //      这里引入了 alibaba 的依赖: fastjson, 同时返回信息由接口文档确定
        String failure = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
        // 2. 如果包含 login, 则直接放行
        if(url.contains("login")){
            log.info("login operation, access allowed");
            filterChain.doFilter(servletRequest, servletResponse);  // 此即为放行操作
            return;
        }else{
            // 3. 否则尝试获取 token
            String jwt = req.getHeader("token");
            if (StringUtils.isEmpty(jwt)){
                // 4. 没有 token, 说明还未登录, 不予放行
                log.info("no token in request header, access not allowed");
                res.getWriter().write(failure);     // 向响应数据写入失败信息
                return;
            }else{
                // 5. 有token字段, 则尝试解析 token
                try{
                    Claims body = JwtUtils.jwtParse(jwt);
                }catch (Exception e){
                    log.error("exception: "+e.getClass().getSimpleName());
                    log.info("token invalid, you may login again");
                    res.getWriter().write(failure);
                    return;
                }
            }
        }
        // 6. 请求携带了有效token, 则放行
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("The token from this request is valid, access allowed");
    }
    // 销毁方法, 只执行一次
    @Override
    public void destroy() {
        log.info("销毁方法 ...");
        Filter.super.destroy();
    }
}
