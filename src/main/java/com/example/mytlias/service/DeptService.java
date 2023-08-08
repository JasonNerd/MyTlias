package com.example.mytlias.service;

import com.example.mytlias.pojo.Department;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeptService {
    /**
     * 列出所有的部门, 无需分页
     */
    List<Department> listDepartment();

    /**
     * 依据部门 id 删除部门
     */
    void deleteDeptByID(Integer id);

    /**
     * 插入一条部门数据
     */
    void add(Department department);

    Department getDeptByID(Integer id);

    void update(Department department);
}
