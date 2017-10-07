package com.puke.pets.api;

/**
 * @author zijiao
 * @version 17/10/6
 */
public class Response<T> {

    private static final String SUCCESS = "0";

    private String ret;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return SUCCESS.equals(ret);
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

}
