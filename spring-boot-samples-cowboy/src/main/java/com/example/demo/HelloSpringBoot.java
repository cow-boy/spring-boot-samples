package com.example.demo;/**
 * Created by HUXU on 2017/8/5.
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * 简单例子
 *
 * @author huxu
 * @create 2017-08-05 16:46
 *
 * @Service用于标注业务层组件
 * @Controller用于标注控制层组件（如struts中的action）
 * @Repository用于标注数据访问组件，即DAO组件
 * @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 *
 **/
@RestController   //注解是@Controller和@ResponseBody的合集,表示这是个控制器bean,并且是将函数的返回值直 接填入HTTP响应体中,是REST风格的控制器。
@RequestMapping("/user")
@Api(value = "接口", description = "接口描述")
public class HelloSpringBoot {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Value("${cowboy.key}")
    private String key;

    /*@Autowired自动导入。
    @PathVariable获取参数。
    @JsonBackReference解决嵌套外链问题。
    @RepositoryRestResourcepublic配合spring-boot-starter-data-rest使用。*/

    /*@RequestMapping(value = {"/","/index"})*/

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Object test(ModelMap modelMap, HttpServletResponse response, HttpServletRequest request,
                       @ApiParam(required = true, value = "登录帐号") @RequestParam(value = "account", required = true) String account,
                       @ApiParam(required = true, value = "登录密码") @RequestParam(value = "password", required = true) String password) {
        Assert.notNull(account, "ACCOUNT");
        Assert.notNull(password, "PASSWORD");
        LOG.info(key);

        return "";
    }


    // 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hell:Hello SpringBoot}")
    private String hello = "Hello springboot";

    /**
     * 默认页<br/>
     * @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
        // 直接返回字符串，框架默认会去 spring.view.prefix 目录下的 （index拼接spring.view.suffix）页面
        // 本例为 /WEB-INF/jsp/index.jsp
        model.put("time", new Date());
        model.put("message", this.hello);
        return "index";
    }

    /**
     * 响应到JSP页面page1
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping("/page1")
    public ModelAndView page1(){
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        ModelAndView mav = new ModelAndView("page/page1");
        mav.addObject("content", hello);
        return mav;
    }

    /**
     * 响应到JSP页面page1（可以直接使用Model封装内容，直接返回页面字符串）
     *
     * @return
     * @author SHANHY
     * @create  2016年1月5日
     */
    @RequestMapping("/page2")
    public String page2(Model model){
        // 页面位置 /WEB-INF/jsp/page/page.jsp
        model.addAttribute("content", hello + "（第二种）");
        return "page/page1";
    }

}
