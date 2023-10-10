package com.rainbow.mytliasvrc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rainbow.mytliasvrc.dao.EmpMapper;
import com.rainbow.mytliasvrc.entity.Employee;
import com.rainbow.mytliasvrc.entity.PageBean;
import com.rainbow.mytliasvrc.entity.QueryArg;
import com.rainbow.mytliasvrc.service.EmpService;
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
        // 不使用 pageHelper 的代码
//        // 1. 先得到整个表的记录数
//        Integer rec_num = empMapper.getTotalRecordNum();
//        // 2. 再查询符合条件的记录
//        arg.setStart((arg.getPage()-1)*arg.getPageSize());
//        List<Employee> employees = empMapper.queryPage(arg);
//        // 3. 封装为 PageBean 然后返回
//        return new PageBean(rec_num, employees);

        // 以下使用 pageHelper
        PageHelper.startPage(arg.getPage(), arg.getPageSize());
        List<Employee> employees = empMapper.queryPage(arg);
        Page<Employee> employeePage = (Page<Employee>) employees;
        return new PageBean((int)employeePage.getTotal(), employeePage.getResult());
    }

    @Override
    public void delEmpByIds(List<Integer> ids) {
        empMapper.delEmpByIds(ids);
    }

    @Override
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
    public void updateEmp(Employee emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }
}
