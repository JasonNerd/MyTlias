package com.rainbow.mytliasvra.service.impl;

import com.rainbow.mytliasvra.dao.EmpMapper;
import com.rainbow.mytliasvra.entity.Employee;
import com.rainbow.mytliasvra.service.EmpService;
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
