package com.example.demo.common;/**
 * Created by HUXU on 2017/9/13.
 */

/**
 * 工具类
 *
 * @author huxu
 * @create 2017-09-13 13:07
 **/

public class CowBoyStr {
    private static final ThreadLocal<StringBuilderHolder> BUD_HOLDER = new ThreadLocal<StringBuilderHolder>() {
        protected StringBuilderHolder initialValue() {
            return new StringBuilderHolder(256);
        }
    };

    public static <T> String join(T... elements) {
        return join(elements, (String)null);
    }

    public static String join(Object[] array, String separator) {
        if(array == null) {
            return null;
        } else if(array.length == 0) {
            return "";
        } else {
            String sep = separator;
            if(separator == null) {
                sep = "";
            }

            StringBuilder buf = ((StringBuilderHolder)BUD_HOLDER.get()).getStringBuilder();
            boolean flag = false;

            for(int i = 0; i < array.length; ++i) {
                if(array[i] != null) {
                    if(flag) {
                        buf.append(sep).append(array[i]);
                    } else {
                        buf.append(array[i]);
                        flag = true;
                    }
                }
            }

            return buf.toString();
        }
    }

    public static boolean isBlank(CharSequence cs) {
        if(cs == null) {
            return true;
        } else {
            int strLen = cs.length();
            if(strLen == 0) {
                return true;
            } else {
                for(int i = 0; i < strLen; ++i) {
                    if(!Character.isWhitespace(cs.charAt(i))) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static String trimToEmpty(String str) {
        return str == null?"":str.trim();
    }

    private CowBoyStr() {
    }
}
