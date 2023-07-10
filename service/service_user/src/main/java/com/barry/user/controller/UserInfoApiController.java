package com.barry.user.controller;

import com.barry.common.result.Result;
import com.barry.common.utils.AuthContextHolder;
import com.barry.model.user.UserInfo;
import com.barry.user.service.UserInfoService;
import com.barry.vo.user.LoginVo;
import com.barry.vo.user.UserAuthVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 13:25
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/api/user")
public class UserInfoApiController {

    @Autowired
    private UserInfoService userInfoService;

    //用手机号登录
    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo) {
//        loginVo.setIp(IpUtil.getIpAddr(request));
        Map<String, Object> info = userInfoService.login(loginVo);
        return Result.ok(info);
    }

    //用户认证接口
    @ApiOperation(value = "用户认证")
    @PostMapping("auth/userAuth")
    public Result userAuth(@RequestBody UserAuthVo userAuthVo, HttpServletRequest request) {
        //传递两个参数，第一个参数用户 id，第二个参数认证数据 vo 对象
        userInfoService.userAuth(AuthContextHolder.getUserId(request),userAuthVo);
        return Result.ok();
    }
    //获取用户 id 信息接口
    @ApiOperation(value = "获取用户id信息")
    @GetMapping("auth/getUserInfo")
    public Result getUserInfo(HttpServletRequest request) {
        Long userId = AuthContextHolder.getUserId(request);
        UserInfo userInfo = userInfoService.getById(userId);
        return Result.ok(userInfo);
    }



}
