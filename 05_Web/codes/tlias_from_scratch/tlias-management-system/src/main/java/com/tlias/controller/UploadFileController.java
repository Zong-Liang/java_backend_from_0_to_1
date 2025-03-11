package com.tlias.controller;

import com.tlias.pojo.Result;
import com.tlias.utils.AliyunOSSUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@Slf4j
public class UploadFileController {
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    //上传文件
    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
        log.info("文件上传: {}", file.getOriginalFilename());
        String url = aliyunOSSUtil.uploadFileToOSS(file.getInputStream(), Objects.requireNonNull(file.getOriginalFilename()));
        log.info("文件上传OSS, url: {}", url);
        return Result.success(url);
    }
}
