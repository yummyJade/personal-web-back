package com.jade.bean;

/*
这个类定义了返回的json格式，即json含有哪些字段

 */

public class BaseResponse<T> {

    private Integer code;
    private String msg;
    private T data;
    private int count;

    public BaseResponse(StatusCode statusCode) {
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(T data, StatusCode statusCode) {
        this.data = data;
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public BaseResponse(Integer code, String msg, T data, int count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}