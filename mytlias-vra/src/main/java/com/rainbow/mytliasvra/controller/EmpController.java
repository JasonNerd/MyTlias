package com.rainbow.mytliasvra.controller;

import com.rainbow.mytliasvra.entity.Employee;
import com.rainbow.mytliasvra.entity.Result;
import com.rainbow.mytliasvra.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emp")
    public Result listEmployee(){
        List<Employee> result = empService.listEmployee();
        return Result.success(result);
    }
}
