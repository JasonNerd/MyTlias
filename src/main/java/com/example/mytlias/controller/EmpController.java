package com.example.mytlias.controller;

import com.example.mytlias.pojo.Employee;
import com.example.mytlias.pojo.PageBean;
import com.example.mytlias.pojo.QueryArg;
import com.example.mytlias.pojo.Result;
import com.example.mytlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    // 2. 条件分页查询, 尝试使用 QueryArg 封装请求参数
    @GetMapping("/emps")
    public Result queryPage(QueryArg arg){
        log.info("查询参数{}", arg);
        PageBean pageBean = empService.queryPage(arg);
        return Result.success(pageBean);
    }

    @DeleteMapping("emps/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids){
        empService.deleteByIds(ids);
        return Result.success();
    }

    @PostMapping("/emps")
    public Result insertEmp(@RequestBody Employee employee){
        log.info("插入一条数据{}", employee);
        empService.insertEmp(employee);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id){
        log.info("获取 id={} 的员工信息", id);
        Employee employee = empService.getEmpById(id);
        return Result.success(employee);
    }

    @PutMapping("/emps")
    public Result updateEmp(@RequestBody Employee employee){
        log.info("更新 {} 的员工信息", employee);
        empService.updateEmp(employee);
        return Result.success();
    }

}
