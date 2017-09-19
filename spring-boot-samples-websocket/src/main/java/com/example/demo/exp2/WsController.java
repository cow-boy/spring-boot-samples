package com.example.demo.exp2;/**
 * Created by huxu on 2017/9/18.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 配置控制器
 *
 * @author HUXU
 * @create 2017-09-18 23:10
 **/

@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;  //实现向浏览器发送消息的功能

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {   //在Spring MVC中，可以直接在参数中获取Principal，Principal中包含有当前用户的用户名
        //方法是向用户发送一条消息，第一个参数是目标用户用户名，第二个参数是浏览器中订阅消息的地址，第三个参数是消息本身
        if (principal.getName().equals("sang")) {
            messagingTemplate.convertAndSendToUser("lenve", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }else{
            messagingTemplate.convertAndSendToUser("sang", "/queue/notifications", principal.getName() + "给您发来了消息：" + msg);
        }
    }

}