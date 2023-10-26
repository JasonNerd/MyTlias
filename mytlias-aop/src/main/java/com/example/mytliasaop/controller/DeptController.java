package com.example.mytliasaop.controller;

import com.example.mytliasaop.ana.MyAnalog;
import com.example.mytliasaop.entity.Department;
import com.example.mytliasaop.entity.Result;
import com.example.mytliasaop.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result getAllDepartments(){
        log.info("获取所有的部门信息");
        List<Department> departments = deptService.getAllDepartments();
        return Result.success(departments);
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

    @GetMapping("/depts/{id}")
    public Result getDeptById(@PathVariable Integer id){
        log.info("依据id获取部门信息: {}", id);
        Department dp = deptService.getDeptById(id);
        return Result.success(dp);
    }

    @PutMapping("/depts")
    public Result updateDept(@RequestBody Department dp){
        log.info("修改部门(新数据): {}", dp);
        deptService.updateDept(dp);
        return Result.success();
    }
}
