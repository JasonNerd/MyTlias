---
title: "MyTlias-员工信息管理系统(五)-yml配置"
date: 2023-07-23T15:03:25+08:00
draft: false
tags: ["Java", "JavaWeb", "Tlias"]
categories: ["JavaWeb"]
twemoji: true
lightgallery: true
---

OSS的参数直接放在代码中, 这不符合开发思想, 一个合理的方法是使用 yml 配置, 将配置文件改为 application.yml. 其好处是以数据为中心, 简洁且层次清晰. properties 文件层次不够清晰
## yml 文件配置
需要注意 yml 文件的格式:
* 大小写敏感
* 数值前边必须有空格，作为分隔符
* 使用缩进表示层级关系，缩进时，不允许使用Tab键，只能用空格（idea中会自动将Tab转换为空格）
* 缩进的空格数目不重要，只要相同层级的元素左侧对齐即可
* `#` 表示注释，从这个字符一直到行尾，都会被解析器忽略

例如:
**对象/Map**:
```yml
user:
  name: zhangsan
  age: 18
  password: 123456
```
**数组/List**:
```yml
hobby:
  - java
  - yuanshen
  - sing
```

**将原配置文件替换为 yml 文件, 注意加上OSS相关设置**
原 properties 文件:
```properties
# mysql database connect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/db_tlias
spring.datasource.username=root
spring.datasource.password=root226
# output the sql running log to screen
mybatis.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
# automatically transfer sql-attr to java-obj-attr only when select
mybatis.configuration.map-underscore-to-camel-case=true
# upload file size limit
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=100MB
# oss connect setting
aliyun.oss.endpoint=https://oss-cn-beijing.aliyuncs.com
aliyun.oss.accessKeyId=LTAI5tS1adS4omhGW8sJCUHc
aliyun.oss.accessKeySecret=SxJeU6N16fd9vVREsYCeyoM9WISg1C
aliyun.oss.bucketName=rainbow-tlias
```
转为 yml 配置:
```yml
spring:
  # MySQL 数据库连接四要素
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/db_tlias
    username: root
    password: root226
  # MultipartFile 文件上传大小限制
  servlet:
    multipart:
      max-file-size: 10MB
      max-request-size: 100MB
# mybatis 数据库运行时日志输出, 开启查询时驼峰命名自动转换
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    map-underscore-to-camel-case: true
# 阿里云OSS 连接四要素
aliyun:
  oss:
    endpoint: https://oss-cn-beijing.aliyuncs.com
    accessKeyId: yourID
    accessKeySecret: yourSecret
    bucketName: yourBucket
```

在 java 文件中, 对连接四要素单独用变量存放, 并使用 **`@Value(${})`** 来为变量赋值:
```java
@Value("${aliyun.oss.endpoint}")
private String endpoint;
@Value("${aliyun.oss.accessKeyId}")
private String accessKeyId;
@Value("${aliyun.oss.accessKeySecret}")
private String accessKeySecret;
@Value("${aliyun.oss.bucketName}")
private String bucketName;
```
OSSClient的创建方式相应的改为:
```java
CredentialsProvider provider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
OSS ossClient = new OSSClientBuilder().build(endpoint, provider);
```
还有一种可选的简化方式, 它使用了 **`@ConfigurationProperties`** 注解, 此时, 需要把这些关于连接配置的属性单独放在一个实体类 `AliOSSConfig`, 再添加**`@ConfigurationProperties`** 注解, 给定前缀, 属性名保持一致, 即可自动注入.
先添加依赖:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor<artifactId>
</dependency>
```
`AliOSSConfig` 如下
```java
@Data
@Component
@ConfigurationProperties(prefix="aliyun.oss")
public class AliOSSConfig{
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
```