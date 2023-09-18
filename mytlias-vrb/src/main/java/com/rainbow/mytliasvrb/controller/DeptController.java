package com.rainbow.mytliasvrb.controller;

import com.rainbow.mytliasvrb.entity.Result;
import com.rainbow.mytliasvrb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result getAllDepartments(){
        log.info("getAllDepartments获取所有的部门信息");
        return Result.success(deptService.getAllDepartments());
    }
}
