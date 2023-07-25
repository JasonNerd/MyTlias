package com.example.mytlias.service;

import com.example.mytlias.pojo.Employee;
import com.example.mytlias.pojo.PageBean;
import com.example.mytlias.pojo.QueryArg;

import java.util.List;

public interface EmpService {
//    PageBean queryPage(Integer page, Integer pageSize);
    // 条件分页查询
    PageBean queryPage(QueryArg arg);

    void deleteByIds(List<Integer> ids);

    void insertEmp(Employee employee);

    Employee getEmpById(Integer id);

    void updateEmp(Employee employee);
}
