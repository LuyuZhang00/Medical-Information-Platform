package com.barry.order.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.barry.model.order.OrderInfo;
import com.barry.order.mapper.OrderMapper;
import com.barry.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 22:54
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderInfo> implements OrderService {
    @Override
    public Long saveOrder(String scheduleId, Long patientId) {
        return null;
    }
}
