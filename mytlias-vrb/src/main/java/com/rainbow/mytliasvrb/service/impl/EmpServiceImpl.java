package com.rainbow.mytliasvrb.service.impl;

import com.rainbow.mytliasvrb.dao.EmpMapper;
import com.rainbow.mytliasvrb.entity.Employee;
import com.rainbow.mytliasvrb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Employee> listEmployee() {
        return empMapper.listEmployee();
    }
}
