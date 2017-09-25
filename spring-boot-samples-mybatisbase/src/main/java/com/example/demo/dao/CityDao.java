package com.example.demo.dao;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.Param;

/**
 * 数据层
 *
 * @author huxu
 * @create 2017-09-25 11:53
 **/

public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);

}
