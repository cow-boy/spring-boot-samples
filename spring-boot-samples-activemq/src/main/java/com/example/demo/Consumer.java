package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by HUXU on 2017/7/8.
 */

@Component
public class Consumer {

    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text){
        System.out.println("张飞接收到的消息："+text);
    }

    @JmsListener(destination = "mytest.queue")
    public void receiveQueue1(String text){
        System.out.println("赵云接收到的消息："+text);
    }

    @JmsListener(destination = "info.mq.topic.video.state")
    public void receiveTopic(String text){
        System.out.println("刘备接收到的Topic消息："+text);
    }

}
