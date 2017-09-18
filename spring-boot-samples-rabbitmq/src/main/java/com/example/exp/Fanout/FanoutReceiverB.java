package com.example.exp.Fanout;/**
 * Created by huxu on 2017/9/10.
 */

/**
 * 消费者Ｂ
 *
 * @author HUXU
 * @create 2017-09-10 23:20
 **/

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }

}
