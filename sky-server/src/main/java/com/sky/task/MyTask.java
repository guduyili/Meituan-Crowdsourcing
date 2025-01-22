package com.sky.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/***
 *@title MyTask
 *@description <TODO description class purpose>
 *@author lzy33
 *@version 1.0.0
 *@create 18/1/2025 下午 5:25
 **/

@Component
@Slf4j
public class MyTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void executeTask(){
        log.info("定时任务开始执行：{}",new Date());
    }
}
