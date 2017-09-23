package com.example.demo.pojo;/**
 * Created by HUXU on 2017/9/23.
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 实体类
 *
 * @author huxu
 * @create 2017-09-23 18:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotNull
    private Long id;

    private String name;

    private Integer age;

}
