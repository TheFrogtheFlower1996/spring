package com.zh.springmvc.exceptions;

/**
 * @author zh
 * @date 2022/4/14 14:02
 * @description:说明 自定义异常：业务异常
 */
public class BusinessException extends RuntimeException{
    private Integer code = 400;
    private String msg = "业务异常";

    public BusinessException() {
        super("业务异常");
    }

    public BusinessException(Integer code) {
        super("业务异常");
        this.code = code;
    }

    public BusinessException(String msg) {
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
