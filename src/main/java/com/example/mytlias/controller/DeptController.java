package com.example.mytlias.controller;

import com.example.mytlias.pojo.Department;
import com.example.mytlias.pojo.Result;
import com.example.mytlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result listDepartment(){
        log.info("查询全部部门数据");
        return Result.success(deptService.listDepartment());
    }

    @DeleteMapping("/depts/{id}")
    public Result deleteDeptByID(@PathVariable Integer id){
        log.info("删除id为{}的部门", id);
        deptService.deleteDeptByID(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Department department){
        log.info("新增 {} 部门", department.getName());
        deptService.add(department);
        return Result.success();
    }

    @GetMapping("depts/{id}")
    public Result getDeptByID(@PathVariable Integer id){
        log.info("获取id={}的部门信息", id);
        Department department = deptService.getDeptByID(id);
        return Result.success(department);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Department department){
        log.info("更新{}的部门信息", department);
        deptService.update(department);
        return Result.success();
    }
}
