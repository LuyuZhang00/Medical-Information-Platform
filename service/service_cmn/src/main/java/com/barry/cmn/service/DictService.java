package com.barry.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.cmn.Dict;

import java.util.List;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-03 9:25
 */
public interface DictService extends IService<Dict> {

    //根据数据 id 查询子数据列表
    List<Dict> findChlidData(Long id);

}
