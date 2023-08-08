package com.example.mytlias.service.impl;

import com.example.mytlias.mapper.DeptLogMapper;
import com.example.mytlias.mapper.DeptMapper;
import com.example.mytlias.pojo.Department;
import com.example.mytlias.pojo.DeptLog;
import com.example.mytlias.service.DeptLogService;
import com.example.mytlias.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private DeptLogService logService;
    @Override
    public List<Department> listDepartment() {
        return deptMapper.listDepartment();
    }

    @Override
    @Transactional // (rollbackFor = Exception.class) // 指定捕捉异常的范围(当出现了不在范围内的异常将不会回滚)
    public void deleteDeptByID(Integer id) {
        try{
            // 还需要依据部门id删除部门员工
            deptMapper.deleteDeptByID(id);
            int i = 1 / 0;  // a runtime exception occurred
            deptMapper.deleteEmpByDept(id);
        } finally {
            // 创建并记录日志
            DeptLog log = new DeptLog();
            log.setCreateTime(LocalDateTime.now());
            log.setDescription("部门{"+id+"}被删除");
            logService.insert(log);
        }
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
