package com.example.mytlias.controller;

import com.example.mytlias.pojo.Employee;
import com.example.mytlias.pojo.Result;
import com.example.mytlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Employee employee){
        log.info("Login info: usr={}, pwd={}", employee.getUsername(), employee.getPassword());
        boolean isOk = empService.checkIn(employee);
        if (isOk) return Result.success();
        else return Result.error();
    }
}
