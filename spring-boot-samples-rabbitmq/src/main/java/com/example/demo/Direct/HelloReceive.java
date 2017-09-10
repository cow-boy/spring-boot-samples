package com.example.demo.Direct;/**
 * Created by HUXU on 2017/9/10.
 */

import com.example.demo.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单的声明列队接收端
 *
 * @author huxu
 * @create 2017-09-10 17:31
 **/
@Component
public class HelloReceive {

    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Receive: "+str);
    }

    @RabbitListener(queues="user")    //监听器监听指定的Queue
    public void process1(User user) {    //用User作为参数
        System.out.println("Receive1: "+user);
    }

}
