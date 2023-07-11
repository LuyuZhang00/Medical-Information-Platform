package com.barry.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.order.OrderInfo;
import com.barry.model.order.PaymentInfo;

import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-11 14:50
 */
public interface PaymentService extends IService<PaymentInfo> {
    void savePaymentInfo(OrderInfo order, Integer status);

    void paySuccess(String outTradeNo, Integer status, Map<String, String> resultMap);

    /**
     * 获取支付记录
     * @param orderId
     * @param paymentType
     * @return
     */
    PaymentInfo getPaymentInfo(Long orderId, Integer paymentType);
}
