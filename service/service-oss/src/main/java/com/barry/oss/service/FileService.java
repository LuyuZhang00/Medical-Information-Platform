package com.barry.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 22:49
 */
public interface FileService {
    String upload(MultipartFile file);
}
