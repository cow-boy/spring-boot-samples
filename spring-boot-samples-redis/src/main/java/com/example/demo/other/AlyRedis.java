package com.example.demo.other;/**
 * Created by huxu on 2017/8/6.
 */

import redis.clients.jedis.Jedis;

/**
 * 连接阿里云测试
 *
 * @author HUXU
 * @create 2017-08-06 15:32
 **/

public class AlyRedis {

    public static void main(String[] args) {
        try {
            String host = "39.108";//控制台显示访问地址
            int port = 6379;
            Jedis jedis = new Jedis(host, port);
//鉴权信息
            jedis.auth("");//password
            String key = "redis";
            String value = "aliyun-redis";
//select db默认为0
            jedis.select(1);
//set一个key
            jedis.set(key, value);
            System.out.println("Set Key " + key + " Value: " + value);
//get 设置进去的key
            String getvalue = jedis.get(key);
            System.out.println("Get Key " + key + " ReturnValue: " + getvalue);
            jedis.quit();
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
