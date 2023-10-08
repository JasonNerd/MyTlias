---
title: "MyTlias-log-1008"
date: 2023-10-08T15:07:12+08: 00
draft: false
tags: ["log", "Tlias"]
categories: ["JavaWeb"]
twemoji: true
lightgallery: true
---

`2023-10-08 15:09:40`:
MyTlias-vra 完成了基本框架的搭建, 主要工作包括:
```java
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
```

MyTlias-vrb 则进一步完善了关于部门数据的增删改查, 涉及到的知识点包括: `路径参数/Restful风格/Slf4j注解/MySQL的CURD语法`, 主要工作包括:
```java
/**
 * MyTlias 第2版:
 *  这一版, 在第一版的基础上, 增添了以下功能:
 *      1. 添加了日志功能
 *      2. 添加了【查询所有部门】的接口
 *      3. 添加了【依据id删除部门】的接口, id 是一个路径参数(PathVariable)
 *          另外, sql 删除语法是: `delete from dept where id=#{id}`
 *      4. 添加了【新增部门】的接口, 请求方式为 post, 数据以json格式封装到请求体中, 直接使用实体进行接收
 *          另外, 需要在 service 层补足实体信息, 随后执行插入, 语法是 `insert into dept(xxx) values (#{xxx})`
 *      5. 添加了【修改部门】的接口, 请求方式为 put, 数据以json格式封装到请求体中, 直接使用实体进行接收
 *          另外, 需要在 service 层补足更新时间, 随后执行更新, 语法是
 *          `update dept set col_a=#{attrA}, ... where id=#{id})`
 */
```

接下来将另起一版, 进一步实现关于员工数据的接口实现.

`2023-10-08 16:29:07`:
分页条件查询





