package com.example.mytliasaop.service.impl;

import com.example.mytliasaop.ana.MyAnalog;
import com.example.mytliasaop.dao.DeptMapper;
import com.example.mytliasaop.entity.Department;
import com.example.mytliasaop.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    @MyAnalog
    public void delDeptById(Integer id) {
        // 增加事务特性, 还需要删除部门内的员工
        deptMapper.delDeptById(id);
//        int a = 1/0;
        deptMapper.delEmpsByDept(id);
    }

    @Override
    @MyAnalog
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
    @MyAnalog
    public void updateDept(Department dp) {
        dp.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dp);
    }
}
