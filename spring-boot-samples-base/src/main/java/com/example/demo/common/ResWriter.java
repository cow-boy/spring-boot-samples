package com.example.demo.common;/**
 * Created by HUXU on 2017/9/13.
 */

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 返回值
 *
 * @author huxu
 * @create 2017-09-13 12:03
 **/

public final class ResWriter {
    public ResWriter() {
    }

    public static void write(HttpServletResponse res, String s) throws IOException {
        PrintWriter writer = res.getWriter();

        try {
            if(s == null) {
                writer.write("null");
            } else {
                writer.write(s);
            }
        } finally {
            writer.flush();
            writer.close();
        }

    }
}
