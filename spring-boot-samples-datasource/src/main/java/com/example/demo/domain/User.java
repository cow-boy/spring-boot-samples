package com.example.demo.domain;/**
 * Created by HUXU on 2017/9/25.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体
 *
 * @author huxu
 * @create 2017-09-25 14:59
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String userName;

    /**
     * 描述
     */
    private String description;

    private City city;

}
