package com.example.demo.service;/**
 * Created by HUXU on 2017/9/23.
 */

import com.example.demo.pojo.User;

import java.util.List;

/**
 * 实现接口
 *
 * @author huxu
 * @create 2017-09-23 18:28
 **/

public interface UserService {

    List<User> findAll();

}
