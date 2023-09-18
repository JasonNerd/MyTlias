package com.rainbow.mytliasvrb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyTlias 第2版:
 *  这一版, 在第一版的基础上, 增添了以下功能:
 *      1. 添加了日志功能
 *      2. 添加了【查询所有部门】的接口
 */
@SpringBootApplication
public class MytliasVrbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MytliasVrbApplication.class, args);
    }

}
