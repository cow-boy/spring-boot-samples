package com.example.demo.controller;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 *
 * @author huxu
 * @create 2017-09-25 11:43
 **/
@RestController
@Api(value = "测试接口", description = "Mybatis接口")
public class CityRestController {

    public static final Logger log = LoggerFactory.getLogger(CityRestController.class);

    @Autowired
    private CityService cityService;

    @ApiOperation(value = "基本方法返回JSON")
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        City cityByName = null;
        try {
            cityByName = cityService.findCityByName(cityName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("日志：{}", cityByName.getCityName());
        return cityByName;
    }

}
