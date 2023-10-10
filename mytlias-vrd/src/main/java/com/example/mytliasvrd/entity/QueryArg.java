package com.example.mytliasvrd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryArg {
    // 存储条件分页查询的参数
    String name;
    Short gender;
    LocalDate begin;
    LocalDate end;
    Integer page;
    Integer pageSize;
//    Integer start;  // 记录起始处, 该字段在不使用pageHelper的情况下启用
}
