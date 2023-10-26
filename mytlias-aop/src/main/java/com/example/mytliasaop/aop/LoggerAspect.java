package com.example.mytliasaop.aop;

import com.alibaba.fastjson.JSONObject;
import com.example.mytliasaop.dao.OperateLogMapper;
import com.example.mytliasaop.entity.OperateLog;
import com.example.mytliasaop.util.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
    @Autowired
    HttpServletRequest request;

    @Autowired
    private OperateLogMapper mp;

    @Around("@annotation(com.example.mytliasaop.ana.MyAnalog)")
    public Object logRecord(ProceedingJoinPoint pt) throws Throwable{
        log.info("进入logRecord代理");
        // 1. 获取登录者的信息
        String jwt = request.getHeader("token");
        Claims claims = JWTUtils.parse(jwt);
        Integer operateUser = Integer.parseInt((String) claims.get("id"));
        // 2. 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 3. 操作类名
        String className = pt.getTarget().getClass().getName();
        // 4. 方法名
        String methodName = pt.getSignature().getName();
        // 5. 方法参数
        String methodParams = Arrays.toString(pt.getArgs());
        // 6. 返回值
        long st = System.currentTimeMillis();
        Object res = pt.proceed();
        String returnValue = JSONObject.toJSONString(res);
        // 7. 操作耗时
        Long costTime = System.currentTimeMillis() - st;

        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className,
                methodName, methodParams, returnValue, costTime);
        log.info("{}", operateLog);
        // 插入 log 记录
        mp.insertLog(operateLog);
        return res;
    }
}
