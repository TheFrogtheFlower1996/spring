package com.zh.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zh
 * @date 2022/3/29 14:36
 * @description:说明
 */
@Component //将该对象交给IOC容器进行实例化
public class TaskJob02 {

    @Scheduled(cron="0/2 * * * * ?")
    public void job1(){
        System.out.println("job01时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Scheduled(cron="0/5 * * * * ?")
    public void job2(){
        System.out.println("job02时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
