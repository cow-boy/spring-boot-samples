package com.example.demo.dao.master;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 DAO 接口类
 *
 * @author huxu
 * @create 2017-09-25 15:13
 **/

@Mapper
public interface UserDao {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User findByName(@Param("userName") String userName);
}