package com.barry.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.order.OrderInfo;
import com.barry.vo.order.OrderCountQueryVo;
import com.barry.vo.order.OrderQueryVo;

import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 22:53
 */
public interface OrderService extends IService<OrderInfo> {
    Long saveOrder(String scheduleId, Long patientId);

    OrderInfo getOrder(String orderId);

    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);

    /**
     * 订单详情
     * @param orderId
     * @return
     */
    Map<String,Object> show(Long orderId);


    /**
     * 取消订单
     * @param orderId
     */
    Boolean cancelOrder(Long orderId);

    //就诊通知
    void patientTips();

    Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo);
}
