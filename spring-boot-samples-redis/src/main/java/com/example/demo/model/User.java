package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by HUXU on 2017/7/18.
 */
@Builder
@Data
public class User {

    private String name;

    private Integer age;

    //User(){}

}
