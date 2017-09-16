package com.example.demo.common;/**
 * Created by HUXU on 2017/9/13.
 */

/**
 * @author huxu
 * @create 2017-09-13 13:08
 **/

public class StringBuilderHolder {

    private final StringBuilder sb;

    public StringBuilderHolder(int capacity) {
        this.sb = new StringBuilder(capacity);
    }

    public StringBuilder getStringBuilder() {
        this.sb.setLength(0);
        return this.sb;
    }

}
