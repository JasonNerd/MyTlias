package com.rainbow.autoconfig.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageBean {
    Integer total;          // 整个员工表的记录数(前端页面显示需要)
    List<Employee> rows;    // 符合查询条件的记录
}
