package com.barry.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.cmn.Dict;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-03 9:25
 */
public interface DictService extends IService<Dict> {

    //根据数据 id 查询子数据列表
    List<Dict> findChlidData(Long id);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);
}
