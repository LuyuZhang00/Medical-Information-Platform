package com.barry.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.user.UserInfo;
import com.barry.vo.user.LoginVo;

import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 13:26
 */
public interface UserInfoService extends IService<UserInfo> {

    //用户手机号登录接口
    Map<String, Object> login(LoginVo loginVo);
}
