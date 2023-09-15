package com.rainbow.mytliasvra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyTlias 第一版:
 *  这一版:
 *      1. 新建了项目, 添加了 lombok, spring web, mybatis, mysql server 等项目依赖
 *          lombok: 简化数据实体书写;
 *          spring web: web开发需要的依赖
 *          mybatis: 依赖管理器
 *          mysql server: 后台数据库使用 mysql
 *      2. 新建了数据库表, 配置了 mysql 连接要素, 新建了数据实体
 *      3. 完成了 E(entity)S(service)C(controller) 框架的搭建, 并书写了第一个 controller 方法,
 *         该方法查询所有员工的信息.
 */
@SpringBootApplication
public class MytliasVraApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytliasVraApplication.class, args);
    }

}
