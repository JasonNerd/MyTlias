package com.example.mytliasvrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MytliasVrdApplication {
    /**
     * 在 c 版本中, 关于两个表的CURD操作已经比较完善
     * 在 d 版本中, 则是添加一些相对实用且必须的功能: 这包括文件云存储, 登录认证等操作
     * 1. 文件云存储, 需要注意 yml配置, 依赖引入, 文件url拼接等事项
     * 2. 登录校验, 首先需要一个 拦截器(Interceptor) or 过滤器(Filter), 它会拦截指定请求, 再放行其中的一部分
     *      例如, 放行的请求可以是已登录请求, 登录状态的校验则使用 jwt 令牌技术实现
     */
    public static void main(String[] args) {
        SpringApplication.run(MytliasVrdApplication.class, args);
    }

}
