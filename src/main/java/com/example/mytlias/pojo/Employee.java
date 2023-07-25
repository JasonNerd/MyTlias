package com.example.mytlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    Integer id;         // id, 主键, 非空, 自增长
    String username;    // 用户名
    String password;    // 密码
    String name;        // 姓名
    Short gender;       // 性别, 1: 男, 2: 女
    String image;       // 照片
    Short job;          // 职位, 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师
    LocalDate entrydate;    // 入职日期
    Integer deptId;         // 部门id
    LocalDateTime createTime;   // 条目创建时间
    LocalDateTime updateTime;   // 最后更新时间
}
