package com.aliyun.oss;

import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.UUID;

public class AliOSSUtils {
    /**
     * 将文件存入服务器并返回访问路径
     * @param file 抽象文件流(MultipartFile)
     * @return 上传到服务器后的文件访问路径(String)
     */
    private AliOSSProperties properties;

    public AliOSSProperties getProperties() {
        return properties;
    }

    public void setProperties(AliOSSProperties properties) {
        this.properties = properties;
    }

    public String upload(MultipartFile file) throws IOException {
        // 0. 获取字段名
        String endpoint=getProperties().getEndpoint();        // 服务器域名
        String accessKeyId=getProperties().getAccessKeyId();     // 访问ID
        String accessKeySecret= getProperties().getAccessKeySecret(); // 访问密钥
        String bucketName=getProperties().getBucketName();      // 数据桶名
        System.out.println(endpoint+"\t"+accessKeyId+"\t"+accessKeySecret+"\t"+bucketName);
        // 1. 配置上传的认证代理
        DefaultCredentialProvider provider = new DefaultCredentialProvider(accessKeyId, accessKeySecret);
        OSS ossClient = new OSSClientBuilder().build(endpoint, provider);
        String filename = file.getOriginalFilename();
        assert filename != null;
        String fileType = filename.substring(filename.lastIndexOf("."));
        String newFileName = UUID.randomUUID()+fileType;
        String storeFolder = "image/";
        // 2. 实际上传工作
        try {
            ossClient.putObject(bucketName, storeFolder+newFileName, new ByteArrayInputStream(file.getBytes()));
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
        // 返回 url
        String htp = "https://";
        return htp+bucketName+'.'+endpoint.substring(htp.length())+storeFolder+newFileName;
    }
}
