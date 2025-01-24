package com.sky.service.impl;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.mapper.UserMapper;
import com.sky.service.ReportService;
import com.sky.service.WorkspaceService;
import com.sky.vo.TurnoverReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *@title ReportServiceImpl
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 24/1/2025 下午 4:35
 **/

@Service
public class ReportServiceImpl implements ReportService {

        @Autowired
        private OrderMapper orderMapper;

        @Autowired
        private UserMapper userMapper;

        @Autowired
        private WorkspaceService workspaceService;

    /**
     * 根据时间区间统计营业额
     * @param begin
     * @param end
     * @return
     */
    @Override
    public TurnoverReportVO getTurnover(LocalDate begin, LocalDate end) {
            List<LocalDate> dateList = new ArrayList<>();

            dateList.add(begin);

            while(!begin.equals(end)){
                begin = begin.plusDays(1);//日期计算，获得指定日期后1天的日期
                dateList.add(begin);
            }

            //存放每天的营业额
            List<Double> turnoverList  = new ArrayList<>();
            for(LocalDate date: dateList){
                //从当天的开始时间持续到结束的时间
                LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
                LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);
                Map map = new HashMap();
                map.put("status", Orders.COMPLETED);
                map.put("begin",beginTime);
                map.put("end",endTime);

                //根据动态条件统计营业额
                Double turnover = orderMapper.sumByMap(map);
                turnover = turnover == null ? 0.0:turnover;
                turnoverList.add(turnover);
            }
            //数据封装

            return TurnoverReportVO.builder()
                    .dateList(org.apache.commons.lang3.StringUtils.join(dateList,","))
                    .turnoverList(org.apache.commons.lang3.StringUtils.join(turnoverList,","))
                    .build();
    }


}
