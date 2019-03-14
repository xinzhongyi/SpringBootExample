package com.test1.dao;

import lombok.Data;

/**
 * Created by Administrator on 2018/4/25.
 */
@Data
public class ResponseResult {
    private Integer code ;
    private String message ;
    private Object data ;
    private ResponseResult(Integer code, String message , Object data){
        this.code = code ;
        this.message = message ;
        this.data = data ;
    }

    private ResponseResult(Integer code,String message){
        this.code = code ;
        this.message = message ;
        this.data = null ;
    }

    public static ResponseResult fail(Integer code, String message){
        return new ResponseResult(code,message) ;
    }

    public static ResponseResult success(Object data){
        return new ResponseResult(0,"success",data) ;
    }
}
