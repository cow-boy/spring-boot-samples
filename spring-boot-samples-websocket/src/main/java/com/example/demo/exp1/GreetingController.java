package com.example.demo.exp1;/**
 * Created by HUXU on 2017/9/18.
 */

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制层 （服务端）
 *
 * @author huxu
 * @create 2017-09-18 16:25
 *
 * 1、接收客户端发送的WebSocket请求，使用的是@MessageMapping。
 * 2、使用‘MessageConverter’进行包装转化成一条消息，发送到指定的目标”，通俗点讲就是我们使用这个方法进行消息的转发发送！
 **/
@Controller
public class GreetingController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/ws")
    public String ws(){
        return "ws";
    }


    /**
     * 写法一  simpMessagingTemplate  （前面我们全局配置中指定了服务端接收的连接以 app大头，所以客户端发送的请求连接应该是/app/change-notice。）
     * @param value
     */
    @MessageMapping("/change-notice")
    public void greeting(String value){
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);
    }

    /**
     * 写法二 @SendTo
     * @param value
     * @return
     */
    @MessageMapping("/change-notice1")
    @SendTo("/topic/notice")
    public String greeting1(String value) {
        return value;
    }

    @MessageMapping("/send")
    @SendTo("/topic/send")
    public SocketMessage send(SocketMessage message) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.date = df.format(new Date());
        return message;
    }

    @Scheduled(fixedRate = 1000)
    //@SendTo("/topic/callback")
    public Object callback() throws Exception {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpMessagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
        return "callback";
    }

}
