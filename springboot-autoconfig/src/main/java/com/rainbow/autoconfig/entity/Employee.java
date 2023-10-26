package com.rainbow.autoconfig.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    String id;
    String username;
    String password;
    String name;
    Short gender;
    String image;
    Short job;
    LocalDate entrydate;
    Integer deptId;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
