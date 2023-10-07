package com.rainbow.mytliasvra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    Integer id;     // 部门id
    String name;    // 部门名称
    LocalDateTime createTime;   // 创建时间
    LocalDateTime updateTime;   // 更新时间
}
