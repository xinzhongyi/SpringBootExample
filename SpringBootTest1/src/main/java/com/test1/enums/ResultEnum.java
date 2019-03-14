package com.test1.enums;

/**
 * Created by Administrator on 2018/5/3.
 */
public enum ResultEnum {
    SYSTEM_ERROR(-1,"系统错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"小于18"),
    PRIMARY_ADUIT(101,"小于19");


    private Integer code ;

    private String msg ;

    ResultEnum(Integer code, String msg) {
        this.code = code;
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
