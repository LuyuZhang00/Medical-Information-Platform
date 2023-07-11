package com.barry.msm.service;

import com.barry.vo.msm.MsmVo;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-09 15:11
 */
public interface MsmService {
    //发送手机验证码
    boolean send(String phone, String code);

    //mq使用发送短信
    boolean send(MsmVo msmVo);
}
