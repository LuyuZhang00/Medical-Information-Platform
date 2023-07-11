package com.barry.hosp.controller.api;

import com.barry.common.result.Result;
import com.barry.hosp.service.DepartmentService;
import com.barry.hosp.service.HospitalService;
import com.barry.hosp.service.HospitalSetService;
import com.barry.hosp.service.ScheduleService;
import com.barry.model.hosp.Hospital;
import com.barry.vo.hosp.HospitalQueryVo;
import com.barry.vo.hosp.ScheduleOrderVo;
import com.barry.vo.order.SignInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-08 22:46
 */
@Api(tags = "前端医院管理接口")
@RestController
@RequestMapping("/api/hosp/hospital")
public class HospitalApiController {
    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation(value = "查询医院列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @PathVariable Integer page,
            @PathVariable Integer limit,
            HospitalQueryVo hospitalQueryVo) {
        //显示上线的医院
        //hospitalQueryVo.setStatus(1);
        Page<Hospital> pageModel = hospitalService.selectPage(page, limit, hospitalQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "根据医院名称获取医院列表")
    @GetMapping("findByHosname/{hosname}")
    public Result findByHosname(
            @ApiParam(name = "hosname", value = "医院名称", required = true)
            @PathVariable String hosname) {
        return Result.ok(hospitalService.findByHosname(hosname));
    }

    @ApiOperation(value = "根据医院编号获取科室列表")
    @GetMapping("department/{hoscode}")
    public Result index(
            @ApiParam(name = "hoscode", value = "医院 code", required = true)
            @PathVariable String hoscode) {
        return Result.ok(departmentService.findDeptTree(hoscode));
    }

    @ApiOperation(value = "医院预约挂号详情")
    @GetMapping("{hoscode}")
    public Result item(
            @ApiParam(name = "hoscode", value = "医院 code", required = true)
            @PathVariable String hoscode) {
        return Result.ok(hospitalService.item(hoscode));
    }

    @Autowired
    private ScheduleService scheduleService;

    @ApiOperation(value = "获取可预约排班数据")
    @GetMapping("auth/getBookingScheduleRule/{page}/{limit}/{hoscode}/{depcode}")
    public Result getBookingSchedule(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Integer page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Integer limit,
            @ApiParam(name = "hoscode", value = "医院 code", required = true)
            @PathVariable String hoscode,
            @ApiParam(name = "depcode", value = "科室 code", required = true)
            @PathVariable String depcode) {
        return Result.ok(scheduleService.getBookingScheduleRule(page, limit,
                hoscode, depcode));
    }

    @ApiOperation(value = "获取排班数据")
    @GetMapping("auth/findScheduleList/{hoscode}/{depcode}/{workDate}")
    public Result findScheduleList(
            @ApiParam(name = "hoscode", value = "医院 code", required = true)
            @PathVariable String hoscode,
            @ApiParam(name = "depcode", value = "科室 code", required = true)
            @PathVariable String depcode,
            @ApiParam(name = "workDate", value = "排班日期", required = true)
            @PathVariable String workDate) {
        return Result.ok(scheduleService.getDetailSchedule(hoscode, depcode,
                workDate));
    }

    @ApiOperation(value = "根据排班 id 获取排班数据")
    @GetMapping("getSchedule/{scheduleId}")
    public Result getSchedule(
            @ApiParam(name = "scheduleId", value = "排班 id", required = true)
            @PathVariable String scheduleId) {
        return Result.ok(scheduleService.getScheduleId(scheduleId));
    }

    @ApiOperation(value = "根据排班 id 获取预约下单数据")
    @GetMapping("inner/getScheduleOrderVo/{scheduleId}")
    public ScheduleOrderVo getScheduleOrderVo(
            @ApiParam(name = "scheduleId", value = "排班 id", required = true)
            @PathVariable("scheduleId") String scheduleId) {
        return scheduleService.getScheduleOrderVo(scheduleId);
    }

    @ApiOperation(value = "获取医院签名信息")
    @GetMapping("inner/getSignInfoVo/{hoscode}")
    public SignInfoVo getSignInfoVo(
            @ApiParam(name = "hoscode", value = "医院 code", required = true)
            @PathVariable("hoscode") String hoscode) {
        return hospitalSetService.getSignInfoVo(hoscode);
    }
}
