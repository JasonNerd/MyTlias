package com.example.mytlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    Integer id;     // 部门 id
    String name;    // 部门名称
    LocalDateTime createTime;   // 创建时间
    LocalDateTime updateTime;   // 更新时间
}
