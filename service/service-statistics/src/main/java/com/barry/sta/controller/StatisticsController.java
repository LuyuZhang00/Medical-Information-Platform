package com.barry.sta.controller;

import com.barry.common.result.Result;
import com.barry.order.client.OrderFeignClient;
import com.barry.vo.order.OrderCountQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-11 17:06
 */
@Api(tags = "统计管理接口")
@RestController
@RequestMapping("/admin/statistics")
public class StatisticsController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @ApiOperation(value = "获取订单统计数据")
    @GetMapping("getCountMap")
    public Result getCountMap(@ApiParam(name = "orderCountQueryVo", value = " 查询对象", required = false)
                                  OrderCountQueryVo orderCountQueryVo) {
        return Result.ok(orderFeignClient.getCountMap(orderCountQueryVo));
    }
}
