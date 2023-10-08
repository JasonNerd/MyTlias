package com.rainbow.mytliasvrc.service;

import com.rainbow.mytliasvrc.entity.Employee;
import com.rainbow.mytliasvrc.entity.PageBean;
import com.rainbow.mytliasvrc.entity.QueryArg;

import java.util.List;

public interface EmpService {
    PageBean queryPage(QueryArg arg);
}
