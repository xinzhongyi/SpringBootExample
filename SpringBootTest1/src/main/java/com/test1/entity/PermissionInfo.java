package com.test1.entity;

import lombok.Data;

/**
 * Created by Administrator on 2018/5/3.
 */
@Data
public class PermissionInfo {
    private Integer id ;
    private String perCode ;
    private String perName ;
    private String perDesc ;
    private String per_type ;
    private String per_url ;
    private String createTime ;
}
