package com.rainbow.mytliasvrc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MytliasVrcApplication {
    /**
     * 在 vrb 版本的基础上, vrc 版本进一步完善关于员工信息查询的功能
     * 1. 条件分页查询: 依据指定条件查询符合条件的值, 并返回其中由页码和页大小规定的一段. 涉及知识点包括:
     *          a. 分页查询, 也即 sql 中关于 limit 关键字的语法 .... limit start, length
     *          b. 动态sql, 借助于 xml, 使用动态sql可以解决部分条件参数为空的问题
     *          c. pageHelper, 借助于 pageHelper 插件可以更方便的实现分页: 他不需要单独编写查询符合条件记录数的sql语句
     * 2. 新增和修改员工
     * 3. 批量删除员工: 动态sql 的 for-each 语法
     */
    public static void main(String[] args) {
        SpringApplication.run(MytliasVrcApplication.class, args);
    }

}
