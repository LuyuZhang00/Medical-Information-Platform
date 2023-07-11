package com.barry.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.hosp.HospitalSet;
import com.barry.vo.order.SignInfoVo;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-03 9:25
 */
public interface HospitalSetService extends IService<HospitalSet> {
    String getSignKey(String hoscode);

    SignInfoVo getSignInfoVo(String hoscode);
}
