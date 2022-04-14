package com.zh.springmvc.exceptions;

/**
 * @author zh
 * @date 2022/4/14 13:56
 * @description:说明 自定义异常 参数异常
 */

public class ParamsException extends RuntimeException {

    private Integer code = 300;
    private String msg = "参数异常";

    public ParamsException() {
        super("参数异常");
    }

    public ParamsException(Integer code) {
        super("参数异常");
        this.code = code;
    }

    public ParamsException(String msg) {
        super(msg);
        this.msg = msg;
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
}
