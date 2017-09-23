package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

/**
 * Created by HUXU on 2017/9/23.
 */
public interface UserService {

    // 测试redis单机查找所有信息
    List<User> findAll();

    // 测试redis集群
    String getRedis();

}
