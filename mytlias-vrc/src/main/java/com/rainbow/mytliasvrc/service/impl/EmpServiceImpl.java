package com.rainbow.mytliasvrc.service.impl;

import com.rainbow.mytliasvrc.dao.EmpMapper;
import com.rainbow.mytliasvrc.entity.Employee;
import com.rainbow.mytliasvrc.entity.PageBean;
import com.rainbow.mytliasvrc.entity.QueryArg;
import com.rainbow.mytliasvrc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean queryPage(QueryArg arg) {
        // 1. 先得到整个表的记录数
        Integer rec_num = empMapper.getTotalRecordNum();
        // 2. 再查询符合条件的记录
        
    }
}
