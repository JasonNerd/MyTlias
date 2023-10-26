package com.example.mytliasaop.service.impl;

import com.example.mytliasaop.ana.MyAnalog;
import com.example.mytliasaop.dao.EmpMapper;
import com.example.mytliasaop.entity.Employee;
import com.example.mytliasaop.entity.PageBean;
import com.example.mytliasaop.entity.QueryArg;
import com.example.mytliasaop.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean queryPage(QueryArg arg) {
        PageHelper.startPage(arg.getPage(), arg.getPageSize());
        List<Employee> employees = empMapper.queryPage(arg);
        Page<Employee> employeePage = (Page<Employee>) employees;
        return new PageBean((int)employeePage.getTotal(), employeePage.getResult());
    }

    @Override
    @MyAnalog
    public void delEmpByIds(List<Integer> ids) {
        empMapper.delEmpByIds(ids);
    }

    @Override
    @MyAnalog
    public void addEmp(Employee emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.addEmp(emp);
    }

    @Override
    public Employee getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    @MyAnalog
    public void updateEmp(Employee emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }

    @Override
    public Employee queryEmployee(Employee employee) {
        return empMapper.queryEmployee(employee);
    }
}
