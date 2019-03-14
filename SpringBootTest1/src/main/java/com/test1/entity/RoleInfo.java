package com.test1.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */
@Data
public class RoleInfo {

    private Integer id ;
    private String roleCode ;
    private String name ;
    private String desc ;
    private String createTime ;
    private List<PermissionInfo> permissionInfos ;
}
