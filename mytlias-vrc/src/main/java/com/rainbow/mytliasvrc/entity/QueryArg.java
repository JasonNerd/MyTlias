package com.rainbow.mytliasvrc.entity;

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
}
