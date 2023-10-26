package com.example.mytliasaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MytliasAopApplication {
    /**
     * 在 version-d 的基础上:
     * 1. 删除部门时也连带删除部门中的员工(解散部门), 这涉及到 springboot 的事务过程,
     * 也即删除的操作必须是原子性的, 而如若此中发生了异常, 则事务回滚.
     * 2. 新建数据库表, 它完整记录了每次操作的日志, 这一需求需要使用到 aop 技术.
     */
    public static void main(String[] args) {
        SpringApplication.run(MytliasAopApplication.class, args);
    }

}
