package com.example.demo;

import com.example.demo.Direct.HelloSender;
import com.example.demo.Topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private TopicSender topicSender;

	@Test
	public void helloSender() {
		helloSender.send();
		helloSender.sendObj();
	}

	/**
	 * sender1发送的消息,routing_key是“topic.message”，所以exchange里面的绑定的binding_key是“topic.message”，topic.＃都符合路由规则;所以sender1
	 发送的消息，两个队列都能接收到；
	 sender2发送的消息，routing_key是“topic.messages”，所以exchange里面的绑定的binding_key只有topic.＃都符合路由规则;所以sender2发送的消息只有队列
	 topic.messages能收到。
	 */
	@Test
	public void topicSender(){
		topicSender.send();
	}


}
