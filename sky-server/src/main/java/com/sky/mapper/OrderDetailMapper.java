package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 *@title OrderDetailMapper
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 16/1/2025 下午 6:09
 **/
@Mapper
public interface OrderDetailMapper {
    void insertBatch(List<OrderDetail> orderDetailList);
}
