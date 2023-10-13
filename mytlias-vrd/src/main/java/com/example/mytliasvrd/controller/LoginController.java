package com.example.mytliasvrd.controller;

import com.example.mytliasvrd.entity.Employee;
import com.example.mytliasvrd.entity.Result;
import com.example.mytliasvrd.service.EmpService;
import com.example.mytliasvrd.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理登录请求
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService service;

    @PostMapping("/login")
    public Result loginOp(@RequestBody Employee employee){
        log.info("登录请求: {}", employee);
        Employee emp = service.queryEmployee(employee);
        // 1. 如果 emp 非空, 则生成 jwt 令牌返回
        if (emp != null){
            // 1.1 构造 payload
            Map<String, Object> payload = new HashMap<>();
            payload.put("id", emp.getId());
            payload.put("name", emp.getName());
            payload.put("username", emp.getUsername());
            // 1.2 生成 jwt
            String jwt = JWTUtils.generate(payload);
            log.info("生成jwt: {}", jwt);
            return Result.success(jwt);
        }
        return Result.error("账号或密码错误(Access Denied)");
    }
}
