---
title: "MyTlias-员工信息管理系统(一)-整体框架的搭建"
date: 2023-07-13T10:49:43+08:00
draft: false
tags: ["Java", "JavaWeb", "Tlias"]
categories: ["JavaWeb"]
twemoji: true
lightgallery: true
---
本小节主要完成项目文件准备, 以及第一个功能实现: 部门信息展示. 并使用PostMan/Apifox测试接口数据是否正常返回, 复习三层架构的实现以及当初引入三层架构的缘起.

## 1. 工作准备
### 1.1. 新建项目
在IDEA新建一个Springboot项目, 选择 Mybatis3 + JDK17, 勾选 lombok/Spring Web/Mybatis/MySQL Server等4个依赖.
### 1.2. 准备数据库表
IDEA连接上MySQL Server, 新建一个 db_tlias 数据库(schema): 执行建表语句和数据插入语句
```sql
-- 部门管理
create table dept(
    id int unsigned primary key auto_increment comment '主键ID',
    name varchar(10) not null unique comment '部门名称',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '部门表';

insert into dept (id, name, create_time, update_time) values
(1,'学工部',now(),now()),
(2,'教研部',now(),now()),
(3,'咨询部',now(),now()),
(4,'就业部',now(),now()),
(5,'人事部',now(),now());

-- 员工管理(带约束)
create table emp (
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
    image varchar(300) comment '图像',
    job tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
    entrydate date comment '入职时间',
    dept_id int unsigned comment '部门ID',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
) comment '员工表';

INSERT INTO emp
(id, username, password, name, gender, image, job, entrydate,dept_id, create_time, update_time) VALUES
(1,'jinyong','123456','金庸',1,'1.jpg',4,'2000-01-01',2,now(),now()),
(2,'zhangwuji','123456','张无忌',1,'2.jpg',2,'2015-01-01',2,now(),now()),
(3,'yangxiao','123456','杨逍',1,'3.jpg',2,'2008-05-01',2,now(),now()),
(4,'weiyixiao','123456','韦一笑',1,'4.jpg',2,'2007-01-01',2,now(),now()),
(5,'changyuchun','123456','常遇春',1,'5.jpg',2,'2012-12-05',2,now(),now()),
(6,'xiaozhao','123456','小昭',2,'6.jpg',3,'2013-09-05',1,now(),now()),
(7,'jixiaofu','123456','纪晓芙',2,'7.jpg',1,'2005-08-01',1,now(),now()),
(8,'zhouzhiruo','123456','周芷若',2,'8.jpg',1,'2014-11-09',1,now(),now()),
(9,'dingminjun','123456','丁敏君',2,'9.jpg',1,'2011-03-11',1,now(),now()),
(10,'zhaomin','123456','赵敏',2,'10.jpg',1,'2013-09-05',1,now(),now()),
(11,'luzhangke','123456','鹿杖客',1,'11.jpg',5,'2007-02-01',3,now(),now()),
(12,'hebiweng','123456','鹤笔翁',1,'12.jpg',5,'2008-08-18',3,now(),now()),
(13,'fangdongbai','123456','方东白',1,'13.jpg',5,'2012-11-01',3,now(),now()),
(14,'zhangsanfeng','123456','张三丰',1,'14.jpg',2,'2002-08-01',2,now(),now()),
(15,'yulianzhou','123456','俞莲舟',1,'15.jpg',2,'2011-05-01',2,now(),now()),
(16,'songyuanqiao','123456','宋远桥',1,'16.jpg',2,'2007-01-01',2,now(),now()),
(17,'chenyouliang','123456','陈友谅',1,'17.jpg',NULL,'2015-03-21',NULL,now(),now());
```
### 1.3. 准备数据实体
员工实体: Employee
部门实体: Department
响应数据: Result
它们均位于`package com.example.mytlias.pojo`
```java
// Employee.java
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
```
```java
// Department.java
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    Integer id;     // 部门 id
    String name;    // 部门名称
    LocalDateTime createTime;   // 创建时间
    LocalDateTime updateTime;   // 更新时间
}
```
```java
// Result.java
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result {
    private Integer code;   // 0: failure, 1: success
    private String msg;
    private Object data;
    // factory
    public static Result success(){
        return new Result(1, "success", null);
    }
    public static Result success(Object data){
        return new Result(1, "success", data);
    }
    public static Result error(Object data){
        return new Result(0, "error", null);
    }
}
```

## 2 完成部门信息展示
在部门信息展示页面中只需要查询得到所有部门的信息即可, 不需要分页, 也么有查询条件
### 2.1 properties
配置数据库连接信息
```yaml
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/db_tlias
spring.datasource.username=root
spring.datasource.password=root226
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
mybatis.configuration.map-underscore-to-camel-case=true
```
### 2.2 DAO 层
也即数据访问层, 该层需要定义数据访问的接口和方法, 新建 mapper 包以存放数据访问代码(这里是通过MyBatis框架访问MySQL数据库的数据表得到的)
```java
@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept")
    public List<Department> listDepartment();
}
```
如上所示, 仅包含一个方法, 也即列出所有的 Department 信息, SQL 语句被写在注解里

### 2.3 Service 层
Service 层调用 DAO 层以获取数据, 在这一层次, 原始数据已经得到了, 它不需要关心数据是具体如何获取, 只关心应该做怎样的处理以使得数据适合 Controller 层的需要:
`package com.example.mytlias.service`
```java
public interface DeptService {
    List<Department> listDepartment();
}
```
`package com.example.mytlias.service.impl`
```java
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Department> listDepartment() {
        return deptMapper.listDepartment();
    }
}
```
如上所示, 首先定义了 Service 接口, 这个接口用于与Controller的通信, 其次新建了 impl 子包, 它存放该接口的实现.

### 2.4 Controller 层
这一层负责与 web 相关的内容, 它接收web请求, 返回响应数据.

`com.example.mytlias.controller`
```java
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result listDepartment(){
        return Result.success(deptService.listDepartment());
    }
}
```
利用 ApiFox 测试结果
访问 `localhost:8080/depts`, 使用 `GET` 方式, 获得数据:
```json
{
    "code": 1,
    "msg": "success",
    "data": [
        {
            "id": 1,
            "name": "学工部",
            "createTime": "2023-07-13T15:10:25",
            "updateTime": "2023-07-13T15:10:25"
        },
        {
            "id": 2,
            "name": "教研部",
            "createTime": "2023-07-13T15:10:25",
            "updateTime": "2023-07-13T15:10:25"
        },
        {
            "id": 3,
            "name": "咨询部",
            "createTime": "2023-07-13T15:10:25",
            "updateTime": "2023-07-13T15:10:25"
        },
        {
            "id": 4,
            "name": "就业部",
            "createTime": "2023-07-13T15:10:25",
            "updateTime": "2023-07-13T15:10:25"
        },
        {
            "id": 5,
            "name": "人事部",
            "createTime": "2023-07-13T15:10:25",
            "updateTime": "2023-07-13T15:10:25"
        }
    ]
}
```
至此, 一个简单的初步的 SpringBoot 项目就弄好了, 以下为项目结构:
根目录: `src/main/java/`
```yml
com.example.mytlias
---- controller
---- ---- DeptController.java
---- ---- EmpController.java
---- mapper
---- ---- EmpMapper.java
---- ---- DeptMapper.java
---- pojo
---- ---- Employee.java
---- ---- Department.java
---- ---- Result.java
---- service
---- impl
---- ---- DeptServiceImpl.java
---- ---- EmpServiceImpl.java
---- DeptService.java
---- EmpService.java
---- MyTliasApplication.java
```
