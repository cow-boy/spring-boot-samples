package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//开启自动配置
@Configuration   //等同于spring的XML配置文件；使用Java代码可以检查类型安全。
@ComponentScan   //组件扫描，可自动发现和装配一些Bean。
@EnableAutoConfiguration   //自动配置。,或在controller类中加，  我测试@SpringBootApplication没有实现开启自动配置功能，不知道为什么

@SpringBootApplication   //等同于@Configuration ，@EnableAutoConfiguration 和 @ComponentScan 三个配置。
@EnableSwagger2
public class CowboyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowboyApplication.class, args);
	}
}
