package com.rainbow.mytliasvrb.service;

import com.rainbow.mytliasvrb.dao.DeptMapper;
import com.rainbow.mytliasvrb.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {
    List<Department> getAllDepartments();
}
