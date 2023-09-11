package com.mytlias.vra.service.impl;

import com.mytlias.vra.dao.EmpMapper;
import com.mytlias.vra.entity.Employee;
import com.mytlias.vra.service.EmpService;
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
