package com.example.demo.Fanout;/**
 * Created by huxu on 2017/9/10.
 */

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送者
 *
 * @author HUXU
 * @create 2017-09-10 23:15
 **/
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am hzb";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }
}
