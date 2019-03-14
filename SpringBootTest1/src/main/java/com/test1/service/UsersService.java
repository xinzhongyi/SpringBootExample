package com.test1.service;

import com.test1.dao.UsersDao;
import com.test1.entity.UsersEntity;
import com.test1.enums.ResultEnum;
import com.test1.exception.TestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */
@Repository
public class UsersService {

    @Autowired
    private UsersDao usersDao ;

    @Cacheable("users")
    public List<UsersEntity> getUsersEntity() {
        return usersDao.getUsersEntity() ;
    }

    @Transactional
    public void addUsersEntity() {
        UsersEntity user1 = new UsersEntity() ;
        user1.setUserName("12345");
        usersDao.insertUsersEntity(user1);

        user1.setUserName("12345678");
        usersDao.insertUsersEntity(user1);
    }

    @Cacheable("usersEntity")
    public UsersEntity getUsersEntityById(int id) {
       return usersDao.getUsersEntityById(id) ;
    }

    @CachePut("usersEntity")
    public UsersEntity updateEntity(int id){
       return usersDao.getUsersEntityById(id) ;
    }
}
