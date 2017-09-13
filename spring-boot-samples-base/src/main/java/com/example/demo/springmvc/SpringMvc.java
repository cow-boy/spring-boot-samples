package com.example.demo.springmvc;/**
 * Created by huxu on 2017/9/12.
 */

import com.example.demo.common.BaseController;
import com.example.demo.common.ResWriter;
import com.example.demo.util.IndentiCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.Map;

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
@Api(value = "测试接口", description = "MVC接口")
public class SpringMvc extends BaseController {   //extends BaseController

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
        return "test4" + code;
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if (errors.hasErrors()) {
            return "error";
        }
        return "sucess";
    }

    @ApiOperation(value = "获取短信验证码")
    @PostMapping("/getsms")
    public Object getSms(
            ModelMap modelMap,
            HttpServletRequest request,
            HttpServletResponse response,
            @ApiParam(required = true, value = "手机号码") @RequestParam(value = "phoneNum", required = true) String phoneNum,
            @ApiParam(required = true, value = "验证类型") @RequestParam(value = "type", required = true) String type,
            @ApiParam(required = true, value = "图形验证码") @RequestParam(value = "idcode", required = true) String idcode) {

        //业务逻辑
        String str = "good";
        return setSuccessModelMap(modelMap, str);
    }

    @GetMapping("/tocenter.html")
    public ModelAndView toInfocenter() {
        ModelAndView view = new ModelAndView("user/infocenter");
        return view;
    }

    @RequestMapping(value = "/list/video/{id}.html", method = { RequestMethod.GET })
    public String videoDetails() {
        return "/sportsland/video";
    }

    @ApiOperation(value = "注册/登陆图形验证码")
    @GetMapping("/identicode")
    public Object identicode(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws IOException {
        Map<String, String> crimg = IndentiCode.crimg(request, response);
        return setSuccessModelMap(modelMap, crimg);
    }

    @RequestMapping(value = "/videohs", method = { RequestMethod.GET })
    public void videohs(HttpServletResponse res) {
        try {
            String str = "videohs";
            ResWriter.write(res, str);
        } catch (IOException e) {
            logger.error("失败：", e);
        }
    }

}
