package com.example.demo.controller;/**
 * Created by HUXU on 2017/9/23.
 */

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 集群控制
 *
 * @author huxu
 * @create 2017-09-23 17:28
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getAll")
    public List<User> getAll(){
        List<User> list = userService.findAll();
        return list;
    }

    @RequestMapping("getRedis")
    public String getRedis(){
        String str = userService.getRedis();
        return str;
    }
}
