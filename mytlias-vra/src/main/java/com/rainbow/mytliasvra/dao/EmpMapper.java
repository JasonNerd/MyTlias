package com.rainbow.mytliasvra.dao;

import com.rainbow.mytliasvra.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    public List<Employee> listEmployee();
}
