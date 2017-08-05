package com.example.demo;/**
 * Created by HUXU on 2017/8/5.
 */

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AOP方法级
 *
 * @author huxu
 * @create 2017-08-05 16:17
 **/
@RestController
@RequestMapping("/test")
@Api(value = "AOP方法级", description = "AOP方法级")
public class TestController {

    @TestAnnotation(name="abc")
    @RequestMapping("/show")
    public String show() {
        return "OK";
    }

    @RequestMapping("/show2")
    public String show2() {
        return "OK2";
    }

}
