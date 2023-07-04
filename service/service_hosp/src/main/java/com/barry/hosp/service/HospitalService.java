package com.barry.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.hosp.Hospital;

import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-04 19:10
 */
public interface HospitalService extends IService<Hospital> {

    // 上传医院
    void save(Map<String, Object> paramMap);

    String getSignKey(String hoscode);

    Object getByHoscode(String hoscode);
}
