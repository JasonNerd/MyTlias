package com.example.mytlias.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;
@Component
public class OssUploader {
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    public String uploadToAliOSS(MultipartFile file) throws IOException{
        // 1. 配置上传的路径信息和认证信息, 创建上传代理
        CredentialsProvider provider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        OSS ossClient = new OSSClientBuilder().build(endpoint, provider);
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String fileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
        String storePath = "image/"+fileName;
        // 2. 实际完成上传的工作
        try {
            ossClient.putObject(bucketName, storePath, new ByteArrayInputStream(file.getBytes()));
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        // 3. 返回上传后的文件资源路径, 该资源全局可见
        String bucketUrl = "https://rainbow-tlias.oss-cn-beijing.aliyuncs.com/";
        return bucketUrl + storePath;
    }
}
