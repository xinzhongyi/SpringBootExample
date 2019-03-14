package com.test1.dao;

import com.test1.entity.UsersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */

public interface UsersDao {
    public List<UsersEntity> getUsersEntity() ;

    public UsersEntity getUsersEntityById(int id) ;

    public void insertUsersEntity(UsersEntity usersEntity) ;
}
