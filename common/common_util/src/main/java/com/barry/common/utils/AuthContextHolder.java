package com.barry.common.utils;

import com.barry.common.helper.JwtHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 9:17
 */

//获取当前用户信息工具类
public class AuthContextHolder {

    //获取当前用户 id
    public static Long getUserId(HttpServletRequest request) {
        //从 header 获取 token
        String token = request.getHeader("token");
        //jwt 从 token 获取 userid
        Long userId = JwtHelper.getUserId(token);
        return userId;
    }
        //获取当前用户名称
    public static String getUserName(HttpServletRequest request) {
        //从 header 获取 token
        String token = request.getHeader("token");
        //jwt 从 token 获取 userid
        String userName = JwtHelper.getUserName(token);
        return userName;
    }
}
