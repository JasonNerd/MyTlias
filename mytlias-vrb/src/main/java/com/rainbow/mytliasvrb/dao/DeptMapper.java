package com.rainbow.mytliasvrb.dao;

import com.rainbow.mytliasvrb.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Department> getAllDepartments();
}
