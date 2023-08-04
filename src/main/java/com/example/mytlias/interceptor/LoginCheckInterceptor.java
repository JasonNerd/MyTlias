package com.example.mytlias.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.example.mytlias.pojo.Result;
import com.example.mytlias.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override   // 目标资源方法执行前执行, 返回true表示放行, 否则不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在 WebMvcConfigurer 中添加了这一 interceptor 并配置了拦截路径后, 那些需要拦截的请求会来到这里
        String url = request.getRequestURL().toString();
        String failure = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
        if(url.contains("login")){
            log.info("login operation, access allowed");
            return true;
        }else{
            String jwt = request.getHeader("token");
            if (StringUtils.isEmpty(jwt)){
                log.info("no token in request header, access not allowed");
                response.getWriter().write(failure);     // 向响应数据写入失败信息
                return false;
            }else{
                try{
                    Claims body = JwtUtils.jwtParse(jwt);
                }catch (Exception e){
                    log.error("exception: "+e.getClass().getSimpleName());
                    log.info("token invalid, you may login again");
                    response.getWriter().write(failure);
                    return false;
                }
            }
        }
        log.info("The token from this request is valid, access allowed");
        return true;
    }

    @Override   // 目标资源方法执行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override   // 视图渲染完毕后执行, 最后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
