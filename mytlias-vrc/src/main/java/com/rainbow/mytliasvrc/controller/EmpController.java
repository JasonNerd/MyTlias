package com.rainbow.mytliasvrc.controller;

import com.rainbow.mytliasvrc.entity.Employee;
import com.rainbow.mytliasvrc.entity.PageBean;
import com.rainbow.mytliasvrc.entity.QueryArg;
import com.rainbow.mytliasvrc.entity.Result;
import com.rainbow.mytliasvrc.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpService service;

    @GetMapping("/emps")
    public Result queryPage(QueryArg arg){
        log.info("分页请求查询, 参数为: {}", arg);
        PageBean pageData = service.queryPage(arg);
        return Result.success(pageData);
    }
}
