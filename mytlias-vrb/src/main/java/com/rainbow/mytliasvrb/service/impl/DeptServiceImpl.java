package com.rainbow.mytliasvrb.service.impl;

import com.rainbow.mytliasvrb.dao.DeptMapper;
import com.rainbow.mytliasvrb.entity.Department;
import com.rainbow.mytliasvrb.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Department> getAllDepartments() {
        return deptMapper.getAllDepartments();
    }
}
