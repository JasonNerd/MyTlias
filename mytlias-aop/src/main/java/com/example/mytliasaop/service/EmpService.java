package com.example.mytliasaop.service;


import com.example.mytliasaop.ana.MyAnalog;
import com.example.mytliasaop.entity.Employee;
import com.example.mytliasaop.entity.PageBean;
import com.example.mytliasaop.entity.QueryArg;

import java.util.List;

public interface EmpService {
    PageBean queryPage(QueryArg arg);

    void delEmpByIds(List<Integer> ids);

    void addEmp(Employee emp);

    Employee getEmpById(Integer id);

    void updateEmp(Employee emp);

    Employee queryEmployee(Employee employee);
}
