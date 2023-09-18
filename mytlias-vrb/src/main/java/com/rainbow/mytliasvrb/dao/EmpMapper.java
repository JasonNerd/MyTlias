package com.rainbow.mytliasvrb.dao;

import com.rainbow.mytliasvrb.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    public List<Employee> listEmployee();
}
