package com.rainbow.mytliasvrb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    Integer id;
    String name;
    LocalDateTime createTime;   // 条目创建时间
    LocalDateTime updateTime;   // 条目更新时间
}
