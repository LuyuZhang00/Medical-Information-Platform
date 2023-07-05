package com.barry.hosp.service;


import com.barry.model.hosp.Department;
import com.barry.vo.hosp.DepartmentQueryVo;
import com.barry.vo.hosp.DepartmentVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-05 10:03
 */
public interface DepartmentService {

    //上传科室接口
    void save(Map<String, Object> paramMap);

    //查询科室接口
    Page<Department> findPageDepartment(int page, int limit, DepartmentQueryVo departmentQueryVo);

    //删除科室接口
    void remove(String hoscode, String depcode);

    List<DepartmentVo> findDeptTree(String hoscode);
}
