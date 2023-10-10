package com.example.mytliasvrd.service.impl;

import com.example.mytliasvrd.dao.DeptMapper;
import com.example.mytliasvrd.entity.Department;
import com.example.mytliasvrd.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Department> getAllDepartments() {
        return deptMapper.getAllDepartments();
    }

    @Override
    public void delDeptById(Integer id) {
        deptMapper.delDeptById(id);
    }

    @Override
    public void add(Department dp) {
        dp.setCreateTime(LocalDateTime.now());
        dp.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dp);
    }

    @Override
    public Department getDeptById(Integer id) {
        return deptMapper.getDeptById(id);
    }

    @Override
    public void updateDept(Department dp) {
        dp.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dp);
    }
}
