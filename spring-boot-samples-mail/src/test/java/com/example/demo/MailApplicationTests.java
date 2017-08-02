package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MailService MailService;

	@Test
	public void testSimpleMail() throws Exception {
		MailService.sendSimpleMail("cow-boy@foxmail.com","test simple mail"," hello this is simple mail");
	}

}
