package com.example.demo.service;

import com.example.demo.domain.City;

/**
 * Created by HUXU on 2017/9/25.
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);

}
