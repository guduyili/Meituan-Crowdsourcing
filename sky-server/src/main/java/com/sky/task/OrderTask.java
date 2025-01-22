package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/***
 *@title OrderTask
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 22/1/2025 下午 1:32
 **/
@Component
@Slf4j
public class OrderTask {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 处理支付超时订单
     */
    // @Scheduled(cron = "0 * * * * ?")//每分钟执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void processTimeoutOrder(){
        log.info("处理支付超时订单：{}",new Date());

        LocalDateTime time = LocalDateTime.now().plusMinutes(-15);

        List<Orders>ordersList = orderMapper.getByStatusAndOrderTime(Orders.PENDING_PAYMENT,time);

        if(ordersList != null && ordersList.size() > 0){
            ordersList.forEach(orders -> {
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("支付超时，自动取消");
                orders.setCancelTime(LocalDateTime.now());
                orderMapper.update(orders);
            });
        }
    }


    /**
     * 处理"派送中“状态的订单
     */
    @Scheduled(cron = "0 0 1 * * ?")//每天凌晨1点触发一次
    public void processDeliverOrder(){
        log.info("处理派送中订单，{}",new Date());

        LocalDateTime time = LocalDateTime.now().plusMinutes(-60);
        List<Orders>ordersList = orderMapper.getByStatusAndOrderTime(Orders.DELIVERY_IN_PROGRESS,time);

        if(ordersList != null && ordersList.size() >0){
            ordersList.forEach(orders -> {
                orders.setStatus(Orders.COMPLETED);
                orderMapper.update(orders);
            });
        }
    }
}
