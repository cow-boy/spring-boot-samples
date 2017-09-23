package com.example.demo.model;/**
 * Created by HUXU on 2017/9/13.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体
 *
 * @author huxu
 * @create 2017-09-13 13:39
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;

    private int age;

}
