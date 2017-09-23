package com.example.demo.springmvc;/**
 * Created by huxu on 2017/9/12.
 */

import com.example.demo.common.BaseController;
import com.example.demo.common.CowBoyStr;
import com.example.demo.common.ResWriter;
import com.example.demo.model.User;
import com.example.demo.util.IndentiCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.*;

import org.joda.time.DateTime;
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
 * 返回类型  @ResponseBody、 setSuccessModelMap(modelMap, str)、 ResWriter.write(res, str);
 *
 * http://127.0.0.1:8080/swagger-ui.html
 **/
@Controller   //声明控制器  @RestController
@RequestMapping({"/", "/index"})
@Api(value = "测试接口", description = "MVC接口")
public class SpringMvc extends BaseController {   //extends BaseController

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "基本方法返回JSON")
    @RequestMapping(value = "/", method = GET)  //http://127.0.0.1:8080/
    @ResponseBody
    public String test1() {
        // 107天之后的日期
        String s = DateTime.now().dayOfYear().addToCopy(107).toString("yyyy-MM-dd");
        return s;
    }

    @ApiOperation(value = "基本方法返回JSON")
    @RequestMapping(value = "/home", method = GET)  //http://127.0.0.1:8080/home
    @ResponseBody
    public String home() {
        return "home";  //返回视图名
    }

    @ApiOperation(value = "带参数方法返回JSON")
    @RequestMapping(value = "/test2", method = GET)  //http://127.0.0.1:8080/test2?max=1&count=2
    @ResponseBody
    public String test2(@RequestParam("max") long max, @RequestParam("count") int count){
        return max + count + "";
    }

    @ApiOperation(value = "带参数方法加默认参数返回JSON")
    @RequestMapping(value = "/test3", method = GET)  //http://127.0.0.1:8080/test2?max=1&count=2
    @ResponseBody
    public String test3(@RequestParam(value = "max", defaultValue = "10") int max,
                        @RequestParam(value = "count", defaultValue = "1") int count){
        return max + count + "";
    }

    @ApiOperation(value = "返回页面和值")
    @GetMapping("/{typeCode}/{timeid}/{linkid}.html")
    public String info(HttpServletRequest req, @PathVariable("typeCode") String typeCode, @PathVariable("timeid") Integer timeid,@PathVariable("linkid") String linkid, Model model) {
        String lang = "zh";
        Integer langId = 1;
        String url = CowBoyStr.join("/home/", lang, "/info");
        try {
            switch (langId) {
                case 1:
                    model.addAttribute("map", Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
                    model.addAttribute("sub", new Spitter());
                    model.addAttribute("subdetail",  new HashMap<Integer, String>() {{
                        put( 1 , "name" );
                        put( 2 , "sex" );
                    }});
                    model.addAttribute("enName", typeCode);
                    break;
                case 2:
                    model.addAttribute("infoVo", new int[]{23, 43, 56, 78});
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("出错：{}", timeid, e);
        }
        return url;
    }

    @ApiOperation(value = "返回ModelAndView")
    @GetMapping("/list/{typeCodeName}.html")
    public ModelAndView infoList(HttpServletRequest req, @PathVariable("typeCodeName") String typeCodeName) {
        String lang = "zh";
        Integer langId = 1;
        String url = CowBoyStr.join("/home/", lang, "/list");
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("enName", typeCodeName);
        try {
            switch (langId) {
                case 1:
                    map.put("vnName", "hello");
                    map.put("sub", new Spitter());
                    break;
                case 2:
                    url = "/sportsland/list";
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            logger.error("列表页", typeCodeName, e);
        }
        return new ModelAndView(url, map);
    }

    @ApiOperation(value = "返回modelAndView")
    @RequestMapping(value="/index1",method=RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/user/index");
        modelAndView.addObject("name", "xxx");
        return modelAndView;
    }

    @ApiOperation(value = "返回的是一个包含模型和视图的ModelAndView对象")
    @RequestMapping(value="/index2",method=RequestMethod.GET)
    public ModelAndView index2(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "xxx");
        modelAndView.setViewName("/user/index");
        return modelAndView;
    }

    /**
     * Model一个模型对象，
     * 主要包含spring封装好的model和modelMap,以及java.util.Map，
     * 当没有视图返回的时候视图名称将由requestToViewNameTranslator决定；
     * @return
     */
    @ApiOperation(value = "返回Map")
    @RequestMapping(value="/index3",method=RequestMethod.GET)
    public Map<String, String> index3(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        //map.put相当于request.setAttribute方法
        return map;
    }
    //响应的view应该也是该请求的view。等同于void返回。

    @ApiOperation(value = "返回String, 通过model进行使用")
    @RequestMapping(value="/index4",method = RequestMethod.GET)
    public String index(Model model) {
        String retVal = "user/index";
        User user = new User();
        user.setName("XXX");
        model.addAttribute("user", user);
        return retVal;
    }

    @ApiOperation(value = "通过配合@ResponseBody来将内容或者对象作为HTTP响应正文返回，适合做即时校验")
    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    @ResponseBody
    public String valid(@RequestParam(value = "userId", required = false) Integer userId,
                        @RequestParam(value = "name") String name) {
        return String.valueOf(true);
    }

    @ApiOperation(value = "返回字符串表示一个视图名称，需要在渲染视图的过程中需要模型的话，就可以给处理器添加一个模型参数，在方法体往模型添加值")
    @RequestMapping(value = "view", method=RequestMethod.GET)
    public void index5(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("xxx", "xxx");
    }

    //返回的结果页面还是：/type
    //这个时候我们一般是将返回结果写在了HttpServletResponse 中了，如果没写的话，
    //spring就会利用RequestToViewNameTranslator 来返回一个对应的视图名称。如果这个时候需要模型的话，处理方法和返回字符串的情况是相同的。
    @ApiOperation(value = "传入对象，验证对象")
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors){
        if (errors.hasErrors()) {
            return "error";
        }
        return "sucess";
    }

    @ApiOperation(value = "获取短信验证码，返回封装的对象")
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

    @ApiOperation(value = "返回视图地址")
    @GetMapping("/tocenter.html")
    public ModelAndView toInfocenter() {
        ModelAndView view = new ModelAndView("user/infocenter");
        return view;
    }

    @ApiOperation(value = "返回视图地址")
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

    @ApiOperation(value = "返回字符串")
    @RequestMapping(value = "/hs", method = { RequestMethod.GET })
    public void videohs(HttpServletResponse res) {
        try {
            String str = "hs";
            ResWriter.write(res, str);
        } catch (IOException e) {
            logger.error("失败：", e);
        }
    }

    @ApiOperation(value = "MD5加密")
    @PostMapping("/md5/{md5}")
    @ResponseBody
    public String md5(@PathVariable("md5") String md5){
        String mw = DigestUtils.md5DigestAsHex(md5.getBytes());//strPass为明码字符
        return mw;
    }

    @ApiOperation(value = "返回实体类对象")
    @RequestMapping("getUser")
    public User getUser(){
        return new User("张三",11);
    }

    @ApiOperation(value = "返回list集合对象，同时也可以返回一个map集合")
    @RequestMapping("lists")
    public List<User> findAll(){
        List<User> list = new ArrayList<>();
        list.add(new User("张三",1));
        list.add(new User("李四",2));
        list.add(new User("王五",3));
        list.add(new User("赵六",4));
        return list;
    }

}