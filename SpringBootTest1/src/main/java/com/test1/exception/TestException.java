package com.test1.exception;

import com.test1.enums.ResultEnum;

/**
 * Created by Administrator on 2018/5/3.
 */
public class TestException extends RuntimeException {

    private Integer code ;

    public TestException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode() ;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
