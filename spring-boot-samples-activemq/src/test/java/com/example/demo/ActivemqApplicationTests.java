package com.example.demo;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync //开启对Async的支持,否则异步任务不启作用
public class ActivemqApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
		/*Destination queue = new ActiveMQQueue("mytest.queue");
		producer.sendMessageQueue(queue, "hello queue!");*/
		Destination topic = new ActiveMQTopic("info.mq.queue.video.state");
		producer.sendMessageTopic(topic, "hello topic!");
	}

	@Test
	public void contextLoads1() throws InterruptedException {
		//while(true){
		Destination queue = new ActiveMQQueue("cowboy.queue");
		Destination topic = new ActiveMQTopic("cowboy.topic");

		for (int i = 0; i < 10; i++) {
			producer.sendMessage(queue, "我是queue孔明：" + i);
			producer.sendMessage(topic, "我是topic刘备：" + i);
		}
		//}
	}
}