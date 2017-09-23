package com.example.demo.controller;/**
 * Created by HUXU on 2017/9/23.
 */

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 控制层
 *
 * @author huxu
 * @create 2017-09-23 18:30
 **/

@RestController
@Api(value = "测试接口", description = "Mybatis接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @Description:整合mybatis的查询所有数据。
     */
    @ApiOperation(value = "基本方法返回JSON")
    @RequestMapping("getAll")
    public List<User> getAll(){
        List<User> list = userService.findAll();
        return list;
    }
}
