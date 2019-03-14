package com.spring.session.dh.Service;

import com.spring.session.dh.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: sks
 * Date: 2019/3/14
 * Time: 15:42
 * Description:
 * \
 */
@Service
public class UserService {

    @Cacheable("usertypes")
    public User getUser(){
        User user = new User() ;
        user.setId(123L);
        user.setUserName("aausername");
        user.setPassword("123123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user ;
    }


}
