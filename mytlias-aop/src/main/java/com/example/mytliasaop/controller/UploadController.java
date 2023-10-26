package com.example.mytliasaop.controller;

import com.aliyun.oss.AliOSSUtils;
import com.example.mytliasaop.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils loader;

    @PostMapping("/upload")
    public Result uploadFile(MultipartFile image) throws IOException{
        log.info("upload file: {}", image.getOriginalFilename());
        log.info("loader is {}", loader);
        log.info("loader.prp is {}", loader.getProperties());
        log.info("loader.prp.getEndpoint is {}", loader.getProperties().getEndpoint());
        log.info("loader.prp.getBucketName is {}", loader.getProperties().getBucketName());
        log.info("loader.prp.getAccessKeyId is {}", loader.getProperties().getAccessKeyId());
        log.info("loader.prp.getAccessKeySecret is {}", loader.getProperties().getAccessKeySecret());
        String url = loader.upload(image);
        log.info("upload finished: {}", url);
        return Result.success(url);
    }
}
