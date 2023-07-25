package com.example.mytlias.service.impl;

import com.example.mytlias.mapper.DeptMapper;
import com.example.mytlias.pojo.Department;
import com.example.mytlias.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Department> listDepartment() {
        return deptMapper.listDepartment();
    }

    @Override
    public void deleteDeptByID(Integer id) {
        deptMapper.deleteDeptByID(id);
    }

    @Override
    public void add(Department department) {
        department.setCreateTime(LocalDateTime.now());
        department.setUpdateTime(LocalDateTime.now());
        deptMapper.add(department);
    }

    @Override
    public Department getDeptByID(Integer id) {
        return deptMapper.getDeptByID(id);
    }

    @Override
    public void update(Department department) {
        department.setUpdateTime(LocalDateTime.now());
        deptMapper.update(department);
    }


}
