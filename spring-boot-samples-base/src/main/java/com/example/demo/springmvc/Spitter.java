package com.example.demo.springmvc;/**
 * Created by huxu on 2017/9/12.
 */

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 校验注解
 *
 * @author HUXU
 * @create 2017-09-12 13:50
 * Java 校验API所提供的校验注解
 **/
@Data
public class Spitter {

    private int id;

    @NotNull
    @Size(min = 5, max = 15)
    private String userName;

    private String password;

    @Digits(integer = 2,fraction = 1)
    private Integer score;

}
