package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * Created by HUXU on 2017/7/8.
 */
@Service("producer")
public class Producer {

    /**
     *
     */
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    //@Scheduled(fixedDelay = 3000)
    public void sendMessageQueue(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    //topic
    public void sendMessageTopic(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    /**
     *  topic和queue共存
     */
    public void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination="return.queue")
    public void consumerMessage(String text){
        System.out.println("从return.queue队列收到的回复为:"+text);
    }

}
