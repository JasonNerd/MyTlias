package com.example.mytlias.mapper;

import com.example.mytlias.pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept")
    List<Department> listDepartment();

    @Delete("delete from dept where id=#{id}")
    void deleteDeptByID(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Department department);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Department getDeptByID(Integer id);


    void update(Department department);
}
