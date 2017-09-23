package com.example.demo.service;/**
 * Created by HUXU on 2017/9/23.
 */

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * 实现类
 *
 * @author huxu
 * @create 2017-09-23 17:35
 **/
@Service
public class UserServiceImpl implements UserService {

    /*@Autowired
    private UserMapper userMapper;*/

    // 注入集群对象
    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 开启缓存:表示在存储空间中添加一个findAll的缓存。
     */
    @Cacheable(value = "findAll", keyGenerator = "keyGen")
    @Override
    public List<User> findAll() {
        System.out.println("如果第二次没有打印此文字说明缓存存在！");
        //return userMapper.findAll();
        return null;
    }

    @Override
    public String getRedis() {
        jedisCluster.set("username", "少年包青天");
        String string = jedisCluster.get("username");
        System.out.println("集群");
        return string;
    }
}