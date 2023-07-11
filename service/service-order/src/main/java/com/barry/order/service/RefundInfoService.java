package com.barry.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.order.PaymentInfo;
import com.barry.model.order.RefundInfo;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-11 15:14
 */
public interface RefundInfoService extends IService<RefundInfo> {

    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}
