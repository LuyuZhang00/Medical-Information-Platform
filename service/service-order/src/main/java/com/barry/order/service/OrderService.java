package com.barry.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.order.OrderInfo;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 22:53
 */
public interface OrderService extends IService<OrderInfo> {
    Long saveOrder(String scheduleId, Long patientId);
}
