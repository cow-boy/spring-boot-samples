package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by HUXU on 2017/7/8.
 */
@Component
public class Consumer2 {

    @JmsListener(destination = "mytest.queue")
    @SendTo("return.queue")    //将return回的值，再发送的"return.queue"队列中
    public String receiveQueue(String text){
        System.out.println("李逵接收到的消息："+text);
        return "我是李逵，返回给你的： "+text;
    }

    @JmsListener(destination = "mytest.topic")
    public void receiveTopic(String text){
        System.out.println("孙权接收到的Topic消息："+text);
    }

}
