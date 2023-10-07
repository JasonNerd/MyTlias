package com.rainbow.mytliasvrb.controller;

import com.rainbow.mytliasvrb.entity.Department;
import com.rainbow.mytliasvrb.entity.Result;
import com.rainbow.mytliasvrb.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result getAllDepartments(){
        log.info("获取所有的部门信息");
        return Result.success(deptService.getAllDepartments());
    }

    @DeleteMapping("/depts/{id}")
    public Result delDeptById(@PathVariable Integer id){
        log.info("删除id={}的部门", id);
        deptService.delDeptById(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result insertNewDept(@RequestBody Department dp){
        log.info("新增部门: {}", dp);
        deptService.add(dp);
        return Result.success();
    }
}
