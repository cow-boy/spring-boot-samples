package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by HUXU on 2017/7/18.
 */
@Builder
@Data
public class User {

    private String name;

    private Integer age;

    User(){}

}
