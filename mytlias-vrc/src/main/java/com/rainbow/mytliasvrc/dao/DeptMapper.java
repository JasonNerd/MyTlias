package com.rainbow.mytliasvrc.dao;

import com.rainbow.mytliasvrc.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept")
    List<Department> getAllDepartments();

    @Delete("delete from dept where id=#{id}")
    void delDeptById(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void add(Department dp);

    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Department getDeptById(Integer id);

    @Select("update dept set name=#{name}, update_time=#{updateTime} where id=#{id}")
    void updateDept(Department dp);
}
