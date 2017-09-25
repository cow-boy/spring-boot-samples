package com.example.demo.result;/**
 * Created by HUXU on 2017/9/25.
 */

/**
 * 统一错误码异常
 *
 * @author huxu
 * @create 2017-09-25 16:49
 **/

public class GlobalErrorInfoException extends Exception {

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}
