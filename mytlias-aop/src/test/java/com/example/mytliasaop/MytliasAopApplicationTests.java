package com.example.mytliasaop;

import com.aliyun.oss.AliOSSProperties;
import com.aliyun.oss.AliOSSUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MytliasAopApplicationTests {
    @Autowired
    AliOSSUtils p;

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        System.out.println(context.getBean(AliOSSUtils.class));
        System.out.println(p.getProperties().getEndpoint());
    }

}
