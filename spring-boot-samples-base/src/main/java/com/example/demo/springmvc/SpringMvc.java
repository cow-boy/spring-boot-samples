package com.example.demo.springmvc;/**
 * Created by huxu on 2017/9/12.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * SpringMvc例子
 *
 * @author HUXU
 * @create 2017-09-12 10:36
 *
 * 请求通过前端控制器DispatcherServlet,通过查询一个或多个处理映射器Handler Mapping将请求发送给选中的控制器，
 * 控制器完成逻辑处理将模型及逻辑视图返回给DispatcherServlet,DispatcherServlet将会使用视图解析器来将逻辑视图名称
 * 匹配为一个特定的视图实现，最后将视图模型返回给客户端；
 *
 * AbstractAnnotationConfigDispatcherServletInitializer
 *
 **/
@Controller   //声明控制器  @RestController
@RequestMapping({"/", "/index"})
public class SpringMvc {


    @RequestMapping(value = "/", method = GET)  //http://127.0.0.1:8080/
    @ResponseBody
    public String test1() {
        return "test1";  //返回视图名
    }

    @RequestMapping(value = "/home", method = GET)  //http://127.0.0.1:8080/home
    @ResponseBody
    public String home() {
        return "home";  //返回视图名
    }

    @RequestMapping(value = "/test2", method = GET)  //http://127.0.0.1:8080/test2?max=1&count=2
    @ResponseBody
    public String test2(@RequestParam("max") long max, @RequestParam("count") int count){
        return max + count + "";
    }

    @RequestMapping(value = "/test3", method = GET)  //http://127.0.0.1:8080/test2?max=1&count=2
    @ResponseBody
    public String test3(@RequestParam(value = "max", defaultValue = "10") int max,
                        @RequestParam(value = "count", defaultValue = "1") int count){
        return max + count + "";
    }

    @RequestMapping(value = "/test4/{code}", method = RequestMethod.GET)
    @ResponseBody
    public String test4(@PathVariable("code") int code, Model model){
        System.out.println(code);
        model.addAttribute("1");
        return "test4";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if (errors.hasErrors()) {
            return "error";
        }
        return "sucess";
    }

}
