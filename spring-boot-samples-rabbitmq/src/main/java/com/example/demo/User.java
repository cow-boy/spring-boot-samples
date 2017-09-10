package com.example.demo;/**
 * Created by HUXU on 2017/9/10.
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 用户对象
 *
 * @author huxu
 * @create 2017-09-10 17:38
 **/
@Data
public class User implements Serializable{

    private static final long serialVersionUID = 7247714666080613254L;

    private String name;

    private Integer age;
}
