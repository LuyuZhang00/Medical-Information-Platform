package com.barry.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.barry.model.order.OrderInfo;
import com.barry.vo.order.OrderCountQueryVo;
import com.barry.vo.order.OrderCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 22:56
 */
public interface OrderMapper extends BaseMapper<OrderInfo> {
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);

}
