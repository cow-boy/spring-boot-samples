package com.example.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Set;
import java.util.UUID;

/**
 * Created by HUXU on 2017/7/18.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/redis")
public class SelectUser {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public User getUser() {
        //查询数据库
        User user = User.builder().age(18).name("cowboy").build();//userService.findByUserName("cowboy");
        //User user1 = new User();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "删除资讯Redis缓存")
    @PostMapping("/delete")
    public Object getSms(
            ModelMap modelMap,
            @ApiParam(required = true, value = "缓存前缀") @RequestParam(value = "str", required = true) String str) {
        Set keys = redisTemplate.keys(str+"*");
        redisTemplate.delete(keys);
        return "okk";
    }
}
