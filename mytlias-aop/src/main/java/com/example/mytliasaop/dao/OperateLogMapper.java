package com.example.mytliasaop.dao;

import com.example.mytliasaop.entity.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    @Insert("insert into operatelog(operateUser, operateTime, className, methodName, " +
            "methodParams, returnValue, costTime) " +
            "values (#{operateUser}, #{operateTime}, #{className}, #{methodName}, " +
            "#{methodParams}, #{returnValue}, #{costTime})")
    void insertLog(OperateLog log);
}
