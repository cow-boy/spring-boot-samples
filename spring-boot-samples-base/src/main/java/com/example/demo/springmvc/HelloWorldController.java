package com.example.demo.springmvc;/**
 * Created by HUXU on 2017/9/25.
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本方法
 *
 * @author huxu
 * @create 2017-09-25 15:59
 **/
@Api(value = "测试接口", description = "热部署接口")
@RestController
public class HelloWorldController {

    @ApiOperation(value = "基本方法返回JSON")
    @PostMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }


    @ApiOperation(value = "热部署测试,http://blog.csdn.net/wjc475869/article/details/52442484")
    @PostMapping("/hello")
    public String sayBy(){
        return "good bye";
    }

}
