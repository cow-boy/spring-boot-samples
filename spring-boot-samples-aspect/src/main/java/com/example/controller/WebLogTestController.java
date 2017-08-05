package com.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 控制层-切入
 *
 * @author huxu
 * @create 2017-08-05 15:00
 **/
@RestController
@EnableAutoConfiguration
@RequestMapping("/log")
@Api(value = "AOP接口", description = "AOP测试")
public class WebLogTestController {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    public String test() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TEST";
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Object login(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request,
                        @ApiParam(required = true, value = "登录帐号") @RequestParam(value = "account", required = true) String account,
                        @ApiParam(required = true, value = "登录密码") @RequestParam(value = "password", required = true) String password) {
        LOG.info("登录帐号:{}",account);
        LOG.info("登录密码:{}",password);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "login";
    }

}