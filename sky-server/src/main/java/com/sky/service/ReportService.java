package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

/***
 *@title ReportService
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 24/1/2025 下午 4:35
 **/
public interface ReportService {


    TurnoverReportVO getTurnover(LocalDate begin, LocalDate end);

    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
