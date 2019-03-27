package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * User: sks
 * Date: 2019/1/31
 * Time: 13:35
 * Description:
 * \
 */
@ApiModel(value = "用户对象")
public class UserInfoDTO {
    @ApiModelProperty(value = "id")
    private int id ;
    @ApiModelProperty(value = "用户姓名")
    private String name ;
    @ApiModelProperty(value = "昵称")
    private String nickName ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
