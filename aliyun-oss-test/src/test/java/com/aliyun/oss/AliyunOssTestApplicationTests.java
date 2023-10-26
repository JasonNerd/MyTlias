package com.aliyun.oss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class AliyunOssTestApplicationTests {
    @Autowired
    AliOSSProperties p;
    @Autowired
    AliOSSUtils utils;

    @Autowired
    private ApplicationContext context;

    @Test
    void testAliConfig() {
        System.out.println(context.getBean(AliOSSConfiguration.class));
    }

    @Test
    void testAliUtil() {
        System.out.println(context.getBean(AliOSSUtils.class));
    }

    @Test
    void testAliProp() {
        System.out.println(context.getBean(AliOSSProperties.class));
        System.out.println(p.getEndpoint());
    }

    @Test
    void testAliUtilProp() {
        System.out.println(utils.getProperties().getAccessKeyId());
    }
}
