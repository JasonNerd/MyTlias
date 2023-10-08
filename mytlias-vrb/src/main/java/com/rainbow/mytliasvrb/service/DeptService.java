package com.rainbow.mytliasvrb.service;

import com.rainbow.mytliasvrb.dao.DeptMapper;
import com.rainbow.mytliasvrb.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartments();

    void delDeptById(Integer id);

    void add(Department dp);

    Department getDeptById(Integer id);

    void updateDept(Department dp);
}
