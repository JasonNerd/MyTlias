---
title: "MyTlias-log-0907"
date: 2023-09-07T10:45:07+08:00
draft: false
tags: ["log", "Tlias"]
categories: ["JavaWeb"]
twemoji: true
lightgallery: true
---


`2023-09-08 09:40:50`:
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

`2023-09-08 10:36:50`:
写完了, 包含 entity/dao/service/controller 四层.
有些细节比如: 
控制反转/依赖注入, 这在层间交流是必要的
以及统一的结果返回(Result实体类)

`2023-09-08 11:08:12`:
时间真快, 明天再写:
部门的增删改查,
员工的分页条件查询,
可能涉及到:
xml+sql, page-helper


`2023-10-07 15:35:47`:
一个月后, 回来了, 继续写.

`2023-10-08 14:09:06`:
关于前后端联调, 有一个对应的前端还是比使用接口测试工具来的直观方便, 注意将
前端工程文件夹打包好, 完整的留存在git项目中, 随后在 gitignore 文件中排除掉
前端工程文件夹, 这样前端工程文件夹就不会被提交到 git 仓库中了.

`2023-10-08 14:12:06`:
添加修改部门的接口, 修改部门需要先依据部门 id 查询出部门信息(也即展示原来的部门信息)
修改部门信息(主要是部门名称)后再依据部门 id 将修改后的数据发回数据库.


