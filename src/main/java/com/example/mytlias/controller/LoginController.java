package com.example.mytlias.controller;

import com.example.mytlias.pojo.Employee;
import com.example.mytlias.pojo.Result;
import com.example.mytlias.service.EmpService;
import com.example.mytlias.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Employee employee){
        log.info("Login info: usr={}, pwd={}", employee.getUsername(), employee.getPassword());
        Employee e = empService.checkIn(employee);
        if (e != null) {
            // 生成一个 JWT令牌 作为响应结果
            Map<String, Object> payload = new HashMap<>();
            payload.put("id", e.getId());
            payload.put("name", e.getName());
            payload.put("username", e.getUsername());
            String jwt = JwtUtils.jwtGenerate(payload);
            return Result.success(jwt);
        } else return Result.error("用户名或密码错误");
    }
}
