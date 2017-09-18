package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaffeineApplicationTests {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void contextLoads() {
	}

	@Autowired
	PersonService personService;

	@Test
	public void localCacheTest() throws JsonProcessingException, InterruptedException{
		System.out.println("第一次："); //从数据库中获取
		Person p = personService.getPersonById(2);
		logger.info("1st time: {}", p);

		System.out.println("第二次："); //从缓存中获取
		p = personService.getPersonById(2);
		logger.info("2nd time: {}",p);

		Thread.sleep(5000);

		System.out.println("第三次："); //5秒钟超时后，从数据库中获取
		p = personService.getPersonById(2);
		logger.info("3rd time: {}", p);

		System.out.println("第四次："); //从缓存中获取
		p = personService.getPersonById(2);
		logger.info("4th time: {}", p);

	}

}
