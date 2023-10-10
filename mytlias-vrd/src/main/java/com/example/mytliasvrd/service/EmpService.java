package com.example.mytliasvrd.service;


import com.example.mytliasvrd.entity.Employee;
import com.example.mytliasvrd.entity.PageBean;
import com.example.mytliasvrd.entity.QueryArg;

import java.util.List;

public interface EmpService {
    PageBean queryPage(QueryArg arg);

    void delEmpByIds(List<Integer> ids);

    void addEmp(Employee emp);

    Employee getEmpById(Integer id);

    void updateEmp(Employee emp);
}
