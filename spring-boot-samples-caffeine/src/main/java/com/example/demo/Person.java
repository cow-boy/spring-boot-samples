package com.example.demo;/**
 * Created by HUXU on 2017/9/18.
 */

import lombok.Data;

import java.util.Date;

/**
 * 实体
 *
 * @author huxu
 * @create 2017-09-18 14:54
 **/
@Data
public class Person {

    private Integer id;
    private String name;
    private Date time;

}
