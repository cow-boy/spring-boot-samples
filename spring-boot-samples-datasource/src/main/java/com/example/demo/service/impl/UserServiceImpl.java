package com.example.demo.service.impl;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.dao.cluster.CityDao;
import com.example.demo.dao.master.UserDao;
import com.example.demo.domain.City;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 *
 * @author huxu
 * @create 2017-09-25 15:04
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName, String cityName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName(cityName);
        user.setCity(city);
        return user;
    }
}