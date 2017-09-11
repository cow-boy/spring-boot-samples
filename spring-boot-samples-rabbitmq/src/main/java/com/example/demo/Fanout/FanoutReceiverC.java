package com.example.demo.Fanout;/**
 * Created by huxu on 2017/9/10.
 */

/**
 * 消费者C
 *
 * @author HUXU
 * @create 2017-09-10 23:21
 **/

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverC  : " + msg);
    }

}