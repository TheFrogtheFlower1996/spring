package com.zh.job;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zh
 * @date 2022/3/29 14:36
 * @description:说明
 */
@Component //将该对象交给IOC容器进行实例化
public class TaskJob {

    public void job1(){
        System.out.println("job1时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public void job2(){
        System.out.println("job2时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
