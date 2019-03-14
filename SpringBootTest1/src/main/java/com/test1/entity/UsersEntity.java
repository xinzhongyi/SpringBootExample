package com.test1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;
import java.util.List;


/**
 * Created by Administrator on 2018/4/25.
 */
@Data
@EqualsAndHashCode
public class UsersEntity {

    private Integer id ;
    @Size( min = 0,max = 5,message = "长度有问题!")
    private String userName ;
    private String password ;
    private String createTime ;
    private String updateTime ;
    private List<RoleInfo> roleInfoList ;
}
