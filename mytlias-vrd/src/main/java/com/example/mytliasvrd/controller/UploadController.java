package com.example.mytliasvrd.controller;

import com.example.mytliasvrd.entity.Result;
import com.example.mytliasvrd.util.OSSLoader;
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
    private OSSLoader loader;

    @PostMapping("/upload")
    public Result uploadFile(MultipartFile image) throws IOException{
        log.info("upload file: {}", image.getOriginalFilename());
        String url = loader.upload(image);
        log.info("upload finished: {}", url);
        return Result.success(url);
    }
}
