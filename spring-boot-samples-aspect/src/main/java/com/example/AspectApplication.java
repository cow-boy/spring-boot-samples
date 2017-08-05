package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
public class AspectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectApplication.class, args);
	}
}
