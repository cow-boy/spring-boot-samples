package com.example.demo.Fanout;/**
 * Created by huxu on 2017/9/10.
 */

/**
 * 消费者A
 *
 * @author HUXU
 * @create 2017-09-10 23:18
 **/

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverA  : " + msg);
    }

}