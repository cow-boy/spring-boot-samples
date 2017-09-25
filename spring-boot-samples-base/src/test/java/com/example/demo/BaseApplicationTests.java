package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() {
		String url = "http://tp.13322.com/pic/player/images/2004122515213.jpg";
		int images = url.indexOf("images");
		System.out.println(images);
		String substring = url.substring(url.indexOf("images"));
		System.out.println(substring);
	}


}
