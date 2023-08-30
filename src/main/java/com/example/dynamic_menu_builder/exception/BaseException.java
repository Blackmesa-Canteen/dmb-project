package com.example.dynamic_menu_builder.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException{
    protected int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    protected String msg = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

    public BaseException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
