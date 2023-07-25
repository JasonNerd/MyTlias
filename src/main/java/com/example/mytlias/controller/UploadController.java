package com.example.mytlias.controller;

import com.example.mytlias.pojo.Result;
import com.example.mytlias.utils.OssUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传文件
 */
@RestController
@Slf4j
public class UploadController {
    @Autowired
    private OssUploader ossUploader;
    @PostMapping("/upload")
    public Result uploadFile(MultipartFile image) throws IOException {
        String url = ossUploader.uploadToAliOSS(image);
        log.info("文件上传完成,文件访问的url: {}", url);
        return Result.success(url);
    }
}
