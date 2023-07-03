package com.barry.hosp.controller;

import com.barry.model.hosp.HospitalSet;
import com.barry.hosp.service.HospitalSetService;
import com.barry.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-03 9:32
 */
@Api(tags = "医院设置管理")
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    //1 查询医院设置表所有信息
    @ApiOperation(value = "获取所有医院设置")
    @GetMapping("findAll")
    public Result findAllHospitalSet() {
        //调用 service 的方法
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }
//    http://localhost:8201/admin/hosp/hospitalSet/findAll


    //2 逻辑删除医院设置
    @ApiOperation(value = "逻辑删除医院设置")
    @DeleteMapping("{id}")
    public Result removeHospSet(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        if(flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
