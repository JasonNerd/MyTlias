package com.rainbow.autoconfig.service;


import com.rainbow.autoconfig.entity.Employee;
import com.rainbow.autoconfig.entity.PageBean;
import com.rainbow.autoconfig.entity.QueryArg;

import java.util.List;

public interface EmpService {
    PageBean queryPage(QueryArg arg);

    void delEmpByIds(List<Integer> ids);

    void addEmp(Employee emp);

    Employee getEmpById(Integer id);

    void updateEmp(Employee emp);

    Employee queryEmployee(Employee employee);
}
