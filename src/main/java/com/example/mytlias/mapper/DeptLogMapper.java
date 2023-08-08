package com.example.mytlias.mapper;

import com.example.mytlias.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into dept_log(create_time, description) values (#{createTime}, #{description})")
    void insert(DeptLog log);
}
