package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("age", "18");
		Assert.assertEquals("cowboy", stringRedisTemplate.opsForValue().get("name"));
	}

	@Test
	public void testget() throws Exception {
		Object age = redisTemplate.opsForValue().get("age");
		System.out.println(age);
	}

	@Test
	public void test1() throws Exception {
		stringRedisTemplate.opsForValue().set("key:20170716", "value:20170716");
		Assert.assertEquals("value:20170716", stringRedisTemplate.opsForValue().get("key:20170716"));
	}

	@Test
	public void test2() {
		Set keys = redisTemplate.keys("key:*");
		redisTemplate.delete(keys);
	}

	@Test
	public void testObj() throws Exception {
		/*User user=new User();
		user.setName("huxu");
		user.setAge(18);*/
		User user = User.builder().age(18).name("cowboy").build();
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("user-key", user);
		operations.set("com.cow.f", user,1, TimeUnit.SECONDS);
		Thread.sleep(1000);
		//redisTemplate.delete("com.neo.f");
		boolean exists=redisTemplate.hasKey("com.cow.f");
		if(exists){
			System.out.println("exists is true");
		}else{
			System.out.println("exists is false");
		}
		// Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
	}



	@Test
	public void contextLoads() {
	}

}
