package com.rainbow.mytliasvrb.dao;

import com.rainbow.mytliasvrb.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Department> getAllDepartments();

    @Delete("delete from dept where id=#{id}")
    void delDeptById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Department dp);

    @Select("select * from dept where id=#{id}")
    Department getDeptById(Integer id);

    @Update("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void updateDept(Department dp);
}
