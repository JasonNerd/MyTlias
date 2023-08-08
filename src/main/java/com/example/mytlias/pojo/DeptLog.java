package com.example.mytlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptLog {
    Integer id; // 主键
    LocalDateTime createTime;   // 条目创建时间
    String description;     // 日志内容
}
