package com.example.mytlias.mapper;

import com.example.mytlias.pojo.Employee;
import com.example.mytlias.pojo.QueryArg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Employee> queryPage(QueryArg arg); // 改为条件分页查询

    void deleteByIds(List<Integer> ids);

    void insertEmp(Employee employee);

    Employee getEmpById(Integer id);

    void updateEmp(Employee employee);
}