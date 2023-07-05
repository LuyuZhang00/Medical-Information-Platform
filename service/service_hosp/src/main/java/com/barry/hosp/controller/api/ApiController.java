package com.barry.hosp.controller.api;


import com.barry.common.exception.YyghException;
import com.barry.common.helper.HttpRequestHelper;
import com.barry.common.result.Result;
import com.barry.common.result.ResultCodeEnum;
import com.barry.common.utils.MD5;
import com.barry.hosp.service.DepartmentService;
import com.barry.hosp.service.HospitalService;

import com.barry.hosp.service.HospitalSetService;
import com.barry.hosp.service.ScheduleService;
import com.barry.model.hosp.Department;


import com.barry.model.hosp.Schedule;
import com.barry.vo.hosp.DepartmentQueryVo;
import com.barry.vo.hosp.ScheduleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-04 19:11
 */

@Api(tags = "医院管理 API 接口")
@RestController
//@CrossOrigin
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ScheduleService scheduleService;

    //删除排班
    @PostMapping("schedule/remove")
    public Result remove(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //获取医院编号和排班编号
        String hoscode = (String)paramMap.get("hoscode");
        String hosScheduleId = (String)paramMap.get("hosScheduleId");

        //TODO 签名校验

        scheduleService.remove(hoscode,hosScheduleId);
        return Result.ok();
    }

    //查询排班接口
    @PostMapping("schedule/list")
    public Result findSchedule(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //医院编号
        String hoscode = (String)paramMap.get("hoscode");

        //科室编号
        String depcode = (String)paramMap.get("depcode");
        //当前页 和 每页记录数
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String)paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 1 : Integer.parseInt((String)paramMap.get("limit"));
        //TODO 签名校验

        ScheduleQueryVo scheduleQueryVo = new ScheduleQueryVo();
        scheduleQueryVo.setHoscode(hoscode);
        scheduleQueryVo.setDepcode(depcode);
        //调用service方法
        Page<Schedule> pageModel = scheduleService.findPageSchedule(page,limit,scheduleQueryVo);
        return Result.ok(pageModel);
    }

    //上传排班接口
    @PostMapping("saveSchedule")
    public Result saveSchedule(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //TODO 签名校验
        scheduleService.save(paramMap);
        return Result.ok();
    }

    //删除科室接口
    @PostMapping("department/remove")
    public Result removeDepartment(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);
        //医院编号 和 科室编号
        String hoscode = (String) paramMap.get("hoscode");
        String depcode = (String) paramMap.get("depcode");
          //TODO 签名校验
//        //1 获取医院系统传递过来的签名,签名进行MD5加密
//        String hospSign = (String)paramMap.get("sign");
//        //2 根据传递过来医院编码，查询数据库，查询签名
//        String signKey = hospitalSetService.getSignKey(hoscode);
//        //3 把数据库查询签名进行MD5加密
//        String signKeyMd5 = MD5.encrypt(signKey);
//        //4 判断签名是否一致
//        if(!hospSign.equals(signKeyMd5)) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }

        departmentService.remove(hoscode, depcode);
        return Result.ok();
    }

    //查询科室接口
    @PostMapping("department/list")
    public Result findDepartment(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //医院编号
        String hoscode = (String) paramMap.get("hoscode");
        //当前页 和 每页记录数
        int page = StringUtils.isEmpty(paramMap.get("page")) ? 1 : Integer.parseInt((String) paramMap.get("page"));
        int limit = StringUtils.isEmpty(paramMap.get("limit")) ? 1 : Integer.parseInt((String) paramMap.get("limit"));
//        //TODO 签名校验
//        //1 获取医院系统传递过来的签名,签名进行MD5加密
//        String hospSign = (String)paramMap.get("sign");
//
//        //2 根据传递过来医院编码，查询数据库，查询签名
//        String signKey = hospitalSetService.getSignKey(hoscode);
//
//        //3 把数据库查询签名进行MD5加密
//        String signKeyMd5 = MD5.encrypt(signKey);
//
//        //4 判断签名是否一致
//        if(!hospSign.equals(signKeyMd5)) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }


        DepartmentQueryVo departmentQueryVo = new DepartmentQueryVo();
        departmentQueryVo.setHoscode(hoscode);
        //调用service方法
        Page<Department> pageModel = departmentService.findPageDepartment(page, limit, departmentQueryVo);
        return Result.ok(pageModel);
    }


    //上传科室接口
    @PostMapping("saveDepartment")
    public Result saveDepartment(HttpServletRequest request) {
        //获取传递过来科室信息
        Map<String, String[]> requestMap = request.getParameterMap();
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(requestMap);

        //获取医院编号
        String hoscode = (String) paramMap.get("hoscode");
        //1 获取医院系统传递过来的签名,签名进行MD5加密
        String hospSign = (String) paramMap.get("sign");

        //2 根据传递过来医院编码，查询数据库，查询签名
        String signKey = hospitalSetService.getSignKey(hoscode);

        //3 把数据库查询签名进行MD5加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //4 判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        //调用service的方法
        departmentService.save(paramMap);
        return Result.ok();
    }


    //查询医院
    @ApiOperation(value = "获取医院信息")
    @PostMapping("hospital/show")
    public Result hospital(HttpServletRequest request) {
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());

        //1.获取医院系统传递过来的签名，签名进行了MD5加密
        String hospSign = (String) paramMap.get("sign");

        //2.根据传递过来的医院编码，查询数据库，查询签名
        String hoscode = (String) paramMap.get("hoscode");
        String signKey = hospitalService.getSignKey(hoscode);

        //3.把数据库查询签名进行MD5加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //4.判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }
        return Result.ok(hospitalService.getByHoscode((String) paramMap.get("hoscode")));
    }


    // 上传医院接口
    @ApiOperation(value = "上传医院")
    @PostMapping("saveHospital")
    public Result saveHospital(HttpServletRequest request) {
        // 获取传递过来的医院信息
        Map<String, Object> paramMap = HttpRequestHelper.switchMap(request.getParameterMap());
        //必须参数校验 略
        //1.获取医院系统传递过来的签名，签名进行了MD5加密
        String hospSign = (String) paramMap.get("sign");

        //2.根据传递过来的医院编码，查询数据库，查询签名
        String hoscode = (String) paramMap.get("hoscode");
        String signKey = hospitalService.getSignKey(hoscode);

        //3.把数据库查询签名进行MD5加密
        String signKeyMd5 = MD5.encrypt(signKey);

        //4.判断签名是否一致
        if (!hospSign.equals(signKeyMd5)) {
            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
        }

        //传输过程中“+”转换成了“ ”，需要替换回来
        String logoData = (String) paramMap.get("logoData");
        if (!StringUtils.isEmpty(logoData)) {
            String logoDataRe = logoData.replaceAll(" ", "+");
            paramMap.put("logoData", logoDataRe);
        }
        // 调用service的方法
        hospitalService.save(paramMap);
        return Result.ok();
    }
}
