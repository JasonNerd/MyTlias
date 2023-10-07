package com.rainbow.mytliasvrb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MyTlias 第2版:
 *  这一版, 在第一版的基础上, 增添了以下功能:
 *      1. 添加了日志功能
 *      2. 添加了【查询所有部门】的接口
 *      3. 添加了【依据id删除部门】的接口, id 是一个路径参数(PathVariable)
 *          另外, sql 删除语法是: `delete from dept where id=#{id}`
 *      4. 添加了【新增部门】的接口, 请求方式为 post, 数据以json格式封装到请求体中, 直接使用实体进行接收
 *          另外, 需要在 service 层补足实体信息, 随后执行插入, 语法是 `insert into dept(xxx) values (#{xxx})`
 */
@SpringBootApplication
public class MytliasVrbApplication {
    public static void main(String[] args) {
        SpringApplication.run(MytliasVrbApplication.class, args);
    }

}
