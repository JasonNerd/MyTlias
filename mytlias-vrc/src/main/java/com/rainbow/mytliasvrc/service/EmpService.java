package com.rainbow.mytliasvrc.service;

import com.rainbow.mytliasvrc.entity.Employee;
import com.rainbow.mytliasvrc.entity.PageBean;
import com.rainbow.mytliasvrc.entity.QueryArg;

import java.util.List;

public interface EmpService {
    PageBean queryPage(QueryArg arg);

    void delEmpByIds(List<Integer> ids);

    void addEmp(Employee emp);

    Employee getEmpById(Integer id);

    void updateEmp(Employee emp);
}
