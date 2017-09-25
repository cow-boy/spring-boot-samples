package com.example.demo.dao.cluster;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 城市 DAO 接口类
 *
 * @author huxu
 * @create 2017-09-25 15:15
 **/

@Mapper
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}