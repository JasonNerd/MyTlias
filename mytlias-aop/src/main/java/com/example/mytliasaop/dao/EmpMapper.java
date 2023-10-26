package com.example.mytliasaop.dao;

import com.example.mytliasaop.entity.Employee;
import com.example.mytliasaop.entity.QueryArg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select count(*) from emp")
    Integer getTotalRecordNum();

    // 由于查询的复杂性, 需要使用 动态SQL 实现
    List<Employee> queryPage(QueryArg arg);

    void delEmpByIds(List<Integer> ids);

    void addEmp(Employee emp);

    @Select("select * from emp where id=#{id}")
    Employee getEmpById(Integer id);

    void updateEmp(Employee emp);

    @Select("select * from emp where username=#{username} and password=#{password}")
    Employee queryEmployee(Employee employee);
}
