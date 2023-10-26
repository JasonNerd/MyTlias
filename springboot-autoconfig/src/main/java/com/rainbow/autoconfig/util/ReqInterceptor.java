package com.rainbow.autoconfig.util;

import com.alibaba.fastjson.JSONObject;
import com.rainbow.autoconfig.entity.Result;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class ReqInterceptor implements HandlerInterceptor {
    // 在此处编写放行逻辑

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行逻辑编写
        // 1. 尝试获取 jwt
        String jwt = request.getHeader("token");
        String failure = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
        if(jwt==null || jwt.equals("")){
            log.info("未携带Token(未登录状态), 不予放行");
            response.getWriter().write(failure);
            return false;
        }else {
            try{
                Claims by = JWTUtils.parse(jwt);
            }catch (Exception e){
                log.error("失效的JWT, 请重新登录");
                response.getWriter().write(failure);
                return false;
            }
        }
        log.info("合法的JWT, 放行");
        return true;
    }
}
