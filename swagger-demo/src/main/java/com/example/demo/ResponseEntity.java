package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * User: sks
 * Date: 2019/1/31
 * Time: 17:26
 * Description:
 * \
 */
@ApiModel(value = "返回消息")
public class ResponseEntity<T> {
    @ApiModelProperty(value = "消息格式")
    private String message ;
    @ApiModelProperty(value = "data数据")
    private T data ;

    public ResponseEntity() {
    }

    public ResponseEntity(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
