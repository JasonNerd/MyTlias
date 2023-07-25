package com.example.mytlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageBean {
    Integer total;  // 查询得到的记录条数
    List<Employee> rows;    // 查询结果
}
