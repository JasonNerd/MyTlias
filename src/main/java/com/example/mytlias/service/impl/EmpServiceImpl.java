package com.example.mytlias.service.impl;

import com.example.mytlias.mapper.EmpMapper;
import com.example.mytlias.pojo.Employee;
import com.example.mytlias.pojo.PageBean;
import com.example.mytlias.pojo.QueryArg;
import com.example.mytlias.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public Employee checkIn(Employee employee) {
        String username = employee.getUsername();
        String password = employee.getPassword();
        return empMapper.getUsrByNamePwd(username, password);
    }

    @Override
    public PageBean queryPage(QueryArg arg) {
        // 使用page helper
        // 1. 规定页码, 页大小
        PageHelper.startPage(arg.getPage(), arg.getPageSize());
        // 2. 执行强转
        List<Employee> employees = empMapper.queryPage(arg);
        Page<Employee> employeePage = (Page<Employee>) employees;
        // 3. 执行sql(由pageHelper拼接)
        return new PageBean((int) employeePage.getTotal(), employeePage.getResult());
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void insertEmp(Employee employee) {
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());
        empMapper.insertEmp(employee);
    }

    @Override
    public Employee getEmpById(Integer id) {
       return empMapper.getEmpById(id);
    }

    @Override
    public void updateEmp(Employee employee) {
        employee.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(employee);
    }
}
