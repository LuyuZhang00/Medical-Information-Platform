package com.barry.oss.controller;

import com.barry.common.result.Result;
import com.barry.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 22:49
 */
@Api(tags = "阿里云文件管理接口")
@RestController
@RequestMapping("/api/oss/file")
public class FileApiController {

    @Autowired
    private FileService fileService;
    //上传文件到阿里云 oss
    @ApiOperation(value = "文件上传")
    @PostMapping("fileUpload")
    public Result fileUpload(MultipartFile file) {
    //获取上传文件
        String url = fileService.upload(file);
        return Result.ok(url);
    }
}
