package com.barry.user.service;

import com.barry.vo.user.LoginVo;

import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 13:26
 */
public interface UserInfoService {
    Map<String, Object> login(LoginVo loginVo);
}
