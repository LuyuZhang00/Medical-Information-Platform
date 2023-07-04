package com.barry.hosp.controller.api;

import com.barry.common.exception.YyghException;
import com.barry.common.helper.HttpRequestHelper;
import com.barry.common.result.Result;
import com.barry.common.result.ResultCodeEnum;
import com.barry.common.utils.MD5;
import com.barry.hosp.service.HospitalService;

import com.barry.hosp.service.HospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@RequestMapping("/api/hosp")
public class ApiController {

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private HospitalSetService hospitalSetService;

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
//        if (StringUtils.isEmpty(hoscode)) {
//            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
//        }
        //签名校验
//        if (!HttpRequestHelper.isSignEquals(paramMap, hospitalSetService.getSignKey(hoscode))) {
//            throw new YyghException(ResultCodeEnum.SIGN_ERROR);
//        }
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
