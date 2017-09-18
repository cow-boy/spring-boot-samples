package com.example.exp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastdfsApplicationTests {

	@Autowired
	private FastDFSClientWrapper dfsClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void delete(){
		dfsClient.deleteFile("/group1/M00/00/00/rBK4mVm9ANmAWXVIAA1rIuRd3Es162.jpg");
	}

}
