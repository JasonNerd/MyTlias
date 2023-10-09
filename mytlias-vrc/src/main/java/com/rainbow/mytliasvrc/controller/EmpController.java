package com.rainbow.mytliasvrc.controller;

import com.rainbow.mytliasvrc.entity.Employee;
import com.rainbow.mytliasvrc.entity.PageBean;
import com.rainbow.mytliasvrc.entity.QueryArg;
import com.rainbow.mytliasvrc.entity.Result;
import com.rainbow.mytliasvrc.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//    批量的员工删除, 请求示例: `/emps/1,2,3`
    @DeleteMapping("/emps/{ids}")
    public Result delEmpByIds(@PathVariable List<Integer> ids){
        log.info("批量删除员工, ids={}", ids);
        service.delEmpByIds(ids);
        return Result.success();
    }

}
