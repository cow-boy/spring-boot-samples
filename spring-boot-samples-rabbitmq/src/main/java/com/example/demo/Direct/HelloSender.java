package com.example.demo.Direct;/**
 * Created by HUXU on 2017/9/10.
 */

import com.example.demo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 简单的声明列队发送端
 *
 * @author huxu
 * @create 2017-09-10 17:24
 **/

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("queue","hello,rabbit~");
    }

    public void sendObj() {
        User user = new User();
        user.setName("cowboy");
        user.setAge(18);
        template.convertAndSend("user", user);
    }

}
