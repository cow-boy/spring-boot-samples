package com.example.demo.common;/**
 * Created by HUXU on 2017/9/21.
 */

import java.util.Random;
import java.util.UUID;

/**
 * Java生成随机不重复推广码邀请码
 *
 * @author huxu
 * @create 2017-09-21 10:18
 *
 * http://blog.csdn.net/huxu981598436/article/details/78048491
 **/

public class PromoCode {

    public static void main(String[] args) throws Exception {
        test13();
        test2();
    }

    public static void test2() {
        for (int i = 1; i < 100000; i++) {
            String value = "";
            value = RC4.encry_RC4_string(String.format("%05d", i), UUID.randomUUID().toString()).toUpperCase();
            System.out.println(value);
        }
    }

    //生成十位数奖品兑换码
    public static void test13() throws Exception{
        int count = 10;
        String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            int d =r.nextInt(62);
            sb.append(str.charAt(d));
        }
        System.out.println(sb.toString());
    }
}
