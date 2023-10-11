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

`2023-10-09 15:31:02`:
先是完成了关于条件分页查询的无 pageHelper 实现, 需要用到动态SQL, 但：
```sql
limit 0, 10
```
和
```sql
order by entrydate desc
```
并不能共存

`2023-10-09 15:34:44`:
然后又完成了关于条件分页查询的 pageHelper 实现.
它不需要 先查询符合条件的总记录数, 只需为 pageHelper 配置 页码和页大小即可完成分页.
```xml
<mapper namespace="com.rainbow.mytliasvrc.dao.EmpMapper">
    <select id="queryPage" resultType="com.rainbow.mytliasvrc.entity.Employee">
<!--        条件分页查询-->
        select id, username, password, name, gender, image, job, entrydate,
        dept_id, create_time, update_time from emp
        <where>
            <if test="name!=null and name!=''">name like concat('%', #{name}, '%')</if>
            <if test="gender!=null">and gender = #{gender}</if>
            <if test="begin!=null and end!=null">and entrydate between #{begin} and #{end}</if>
        </where>
        order by entrydate desc
    </select>
</mapper>
```
查询操作不包含分页参数.

`2023-10-09 15:57:26`:
批量删除员工, 请求参数示例: `/emps/1,2,3`, 使用到的 sql 语法包括 for-each

`2023-10-10 15:52:36`:
完成了员工的新增和更新操作. 接下来完成文件云服务和登录操作.

`2023-10-10 16:54:57`:
新建立了 version-d 版本, 遇到了一些麻烦, 直接的文件复制还需要修改 import 语句以及 package 语句.
另外, 在引入新的依赖后必须使用 maven rebiuld 一下.

`2023-10-11 14:25:25`:
尝试重启 aliyun.oss 服务.


`2023-10-11 14:46:51`:
通过 yml 定义一些全局设置, 在代码中则通过:
`@Value("${aliyun.oss.endpoint}")`
来进行赋值

`2023-10-11 15:52:59`:
应用很顺利, 总结步骤如下:
1. 创建一个 aliyun oss 服务, 创建 bucket, 记录 id secret.
2. 项目中引入aliyun oss 依赖, 注意使用 maven 重新编译.
2. 按照官方的文件上传服务示例, 编写上传代码, 注意组装url.
    ```py
    String htp = "https://";
    return htp+bucketName+'.'+endpoint.substring(htp.length())+storeFolder+newFileName;
    ```
3. 上传服务器的认证代理四要素在yml中配置, 使用`@Value`注解完成赋值.
4. 随后创建处理请求的 controller, 编写上传接口.


`2023-10-11 15:57:21`:
接下来立即启动 login 验证服务.





