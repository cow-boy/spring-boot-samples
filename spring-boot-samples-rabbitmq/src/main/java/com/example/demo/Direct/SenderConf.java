package com.example.demo.Direct;/**
 * Created by HUXU on 2017/9/10.
 */

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 交换机
 *
 * @author huxu
 * @create 2017-09-10 18:50
 **/
@Configuration
public class SenderConf {

    /**
     * Direct模式相当于一对一模式,一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!，可以一个发送者多个接收者或多个发送者多个接收者
     * direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routing_key, 消息的routing_key完全匹配时, 才会被交换器投送到绑定的队列中去。
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue userQueue() {
        return new Queue("user");
    }
}
