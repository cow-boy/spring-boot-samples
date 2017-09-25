package com.example.demo.controller;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层
 *
 * @author huxu
 * @create 2017-09-25 14:58
 **/

@RestController
@Api(value = "测试接口", description = "Mybatis多数据源接口")
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * query based on user name and city name
     * @param userName
     * @param cityName
     * @return
     */
    @ApiOperation(value = "基本方法返回JSON")
    @PostMapping("/api/user")
    public User findByName(@ApiParam(required = true, value = "用户名") @RequestParam(value = "userName", required = true) String userName,
                           @ApiParam(required = true, value = "城市名") @RequestParam(value = "cityName", required = true) String cityName) {
        return userService.findByName(userName, cityName);
    }

}