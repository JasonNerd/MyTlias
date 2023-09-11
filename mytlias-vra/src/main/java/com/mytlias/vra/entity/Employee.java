package com.mytlias.vra.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    Integer id;         // 用户id
    String username;    // 用户名, 唯一
    String password;    // 密码, 初始 123456
    String name;        // 用户昵称
    Short gender;       // 性别, 1: 男, 2: 女
    Short job;          // 职位, 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师
    LocalDate entrydate;    // 入职日期
    Integer deptId;         // 所在部门 id
    LocalDateTime createTime;   // 创建时间
    LocalDateTime updateTime;   // 最后更新时间
}
