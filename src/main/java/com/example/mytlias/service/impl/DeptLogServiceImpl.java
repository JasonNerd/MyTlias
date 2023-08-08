package com.example.mytlias.service.impl;

import com.example.mytlias.mapper.DeptLogMapper;
import com.example.mytlias.pojo.DeptLog;
import com.example.mytlias.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 表示总是生成一个独立的新事务
    @Override
    public void insert(DeptLog log) {
        deptLogMapper.insert(log);
    }
}
