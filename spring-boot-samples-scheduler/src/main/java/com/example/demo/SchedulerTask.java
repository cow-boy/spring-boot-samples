package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HUXU on 2017/8/3.
 */
@Component
public class SchedulerTask {

    private int count=0;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //上一次开始执行时间点之后6秒再执行
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }

    //第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
    @Scheduled(initialDelay=1000, fixedRate=6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
