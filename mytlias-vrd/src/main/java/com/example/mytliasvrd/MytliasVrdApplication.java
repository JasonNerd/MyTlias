package com.example.mytliasvrd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MytliasVrdApplication {
    /**
     * 在 c 版本中, 关于两个表的CURD操作已经比较完善
     * 在 d 版本中, 则是添加一些相对实用且必须的功能: 这包括文件云存储, 登录认证等操作
     */
    public static void main(String[] args) {
        SpringApplication.run(MytliasVrdApplication.class, args);
    }

}
