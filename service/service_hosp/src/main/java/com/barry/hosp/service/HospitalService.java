package com.barry.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.hosp.Hospital;
import com.barry.vo.hosp.HospitalQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-04 19:10
 */
public interface HospitalService {

    // 上传医院
    void save(Map<String, Object> paramMap);

    //根据医院编号查询
    String getSignKey(String hoscode);

    //根据医院编号查询
    Object getByHoscode(String hoscode);

    //医院列表(条件查询分页)
    Page selectPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);

    //更新医院上线状态
    void updateStatus(String id, Integer status);

    //医院详情信息
    Map<String, Object> getHospById(String id);

    String getHospName(String hoscode);

//    Page<Hospital> selectHospPage(Integer page, Integer limit, HospitalQueryVo hospitalQueryVo);

    List findByHosname(String hosname);
}
