package com.example.demo;/**
 * Created by HUXU on 2017/9/10.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;


/**
 * 配置类，作用为指定队列，交换器类型及绑定操作
 *
 * @author huxu
 * @create 2017-09-10 17:14
 **/

@Configuration
public class RabbitConfig {

    /**
     * Direct模式相当于一对一模式,一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!
     */
    //声明队列
    @Bean
    public Queue queue1() {
        return new Queue("queue", true); // true表示持久化该队列
    }

    @Bean
    public Queue userQueue() {     //对象
        return new Queue("user");
    }

    /**
     *
     */

}
