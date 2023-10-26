package com.aliyun.oss;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(AliOSSProperties.class)
@Configuration
public class AliOSSConfiguration {

    @Bean
    public AliOSSUtils aliOSSUtils(AliOSSProperties properties){
        AliOSSUtils aliOSSUtils = new AliOSSUtils();
        aliOSSUtils.setProperties(properties);
        return aliOSSUtils;
    }
}
