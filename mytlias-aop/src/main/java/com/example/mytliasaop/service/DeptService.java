package com.example.mytliasaop.service;

import com.example.mytliasaop.ana.MyAnalog;
import com.example.mytliasaop.entity.Department;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartments();

    void delDeptById(Integer id);

    void add(Department dp);

    Department getDeptById(Integer id);

    void updateDept(Department dp);
}
