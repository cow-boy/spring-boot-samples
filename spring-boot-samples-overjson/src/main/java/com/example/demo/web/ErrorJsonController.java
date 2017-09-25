package com.example.demo.web;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.constant.CityErrorInfoEnum;
import com.example.demo.domain.City;
import com.example.demo.result.GlobalErrorInfoException;
import com.example.demo.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层
 *
 * @author huxu
 * @create 2017-09-25 16:44
 **/
@Api(value = "测试接口", description = "封装返回接口")
@RestController
public class ErrorJsonController {

    @ApiOperation(value = "基本方法返回封装对象")
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public ResultBody findOneCity(@RequestParam(value = "cityName", required = false) String cityName) throws GlobalErrorInfoException {
        // 入参为空
        if (StringUtils.isEmpty(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }
        if (StringUtils.isNumeric(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.CITY_EXIT);
        }
        //
        return new ResultBody(new City(1L,2L,"深圳","go go go"));
    }
}