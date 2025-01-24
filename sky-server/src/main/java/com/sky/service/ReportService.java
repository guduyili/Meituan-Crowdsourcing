package com.sky.service;

import com.sky.vo.TurnoverReportVO;

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
}
