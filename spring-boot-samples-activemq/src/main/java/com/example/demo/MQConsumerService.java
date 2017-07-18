package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by HUXU on 2017/7/8.
 * topic和queue共存
 */
@Service
public class MQConsumerService {

    @JmsListener(destination = "cowboy.queue" ,containerFactory="queueListenerFactory")// 增加对应处理的监听器工程
    public void receiveQueue(TextMessage text) throws Exception {
        System.out.println("孔明一员大将收到消息:"+text.getText());
    }

    @JmsListener(destination="cowboy.topic", containerFactory="topicListenerFactory")// 增加对应处理的监听器工程
    public void receiveTopic(TextMessage text) throws JMSException{
        System.out.println("主公好，我是关羽收到消息："+text.getText());
    }

    @JmsListener(destination="cowboy.topic", containerFactory="topicListenerFactory")// 增加对应处理的监听器工程
    public void receiveTopic1(TextMessage text) throws JMSException{
        System.out.println("主公好，我是张飞收到消息："+text.getText());
    }

}
