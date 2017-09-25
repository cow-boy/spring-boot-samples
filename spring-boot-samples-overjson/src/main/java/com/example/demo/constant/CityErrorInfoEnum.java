package com.example.demo.constant;/**
 * Created by HUXU on 2017/9/25.
 */

import com.example.demo.result.ErrorInfoInterface;

/**
 * 业务错误码 案例
 *
 * @author huxu
 * @create 2017-09-25 16:46
 **/

public enum CityErrorInfoEnum implements ErrorInfoInterface {

    PARAMS_NO_COMPLETE("000001","params no complete"),
    CITY_EXIT("000002","city is not number!");

    private String code;

    private String message;

    CityErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
