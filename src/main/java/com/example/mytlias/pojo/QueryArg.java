package com.example.mytlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QueryArg {
    String name;    // 请求名称
    Short gender;   // 性别
    LocalDate begin;    // 起始日期
    LocalDate end;      // 截止日期
    Integer page;       // 页码
    Integer pageSize;   // 页大小
}
