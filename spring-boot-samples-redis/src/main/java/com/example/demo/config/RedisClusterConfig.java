package com.example.demo.config;/**
 * Created by HUXU on 2017/9/23.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Redis集群配置
 *
 * @author huxu
 * @create 2017-09-23 17:22
 **/

@Configuration
public class RedisClusterConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;

    @Bean
    public JedisCluster getJedisCluster() {
        // 分割集群节点
        String[] cNodes = clusterNodes.split(",");

        Set<HostAndPort> nodes = new HashSet<>();
        // 循环集群节点对象
        // 192.168.26.30:6379
        for (String node : cNodes) {
            // 循环分割为IP，port.
            String[] hp = node.split(":");
            // 将ip地址，端口号添加到set集合中
            nodes.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
        }
        JedisCluster jedisCluster = new JedisCluster(nodes);
        return jedisCluster;
    }
}