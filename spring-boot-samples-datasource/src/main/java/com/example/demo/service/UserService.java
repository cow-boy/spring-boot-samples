package com.example.demo.service;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.domain.User;

/**
 * 用户业务接口层
 *
 * @author huxu
 * @create 2017-09-25 15:01
 **/

public interface UserService {

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    User findByName(String userName, String cityName);
}
