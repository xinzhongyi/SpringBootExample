package com.spring.session.dh.controller;

import com.spring.session.dh.Service.UserService;
import com.spring.session.dh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: sks
 * Date: 2019/3/14
 * Time: 15:01
 * Description:
 * \
 */
@RestController
public class UserController {

    @Autowired
    UserService userService ;

    @GetMapping
    public User getUser(){
        return userService.getUser() ;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        System.out.println(session.getMaxInactiveInterval()) ;
        return session.getId();
    }
}
