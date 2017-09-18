package com.example.exp.callback;/**
 * Created by HUXU on 2017/9/10.
 */

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * topic接收者2
 *
 * @author huxu
 * @create 2017-09-10 18:15
 **/

@Component
@RabbitListener(queues = "topic.messages")
public class CallBackReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("CallBackReceiver : " +msg);
    }

}
