package com.barry.order.service;

import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-11 14:47
 */
public interface WeixinService {
    Map createNative(Long orderId);

    Map<String, String> queryPayStatus(Long orderId, String name);

    Boolean refund(Long orderId);
}
