package com.test1.controller;

import com.test1.dao.ResponseResult;
import com.test1.entity.UsersEntity;
import com.test1.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2018/4/25.
 */
@RestController
@RequestMapping("users")
@Validated
public class UsersController {

    @Autowired
    private UsersService usersService ;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseResult getUsersEntity(){
        return ResponseResult.success(usersService.getUsersEntity());
    }

    @PostMapping
    public ResponseResult addUersEntity(@Valid @RequestBody UsersEntity usersEntity){
        usersService.addUsersEntity() ;
        return ResponseResult.success("") ;
    }

    @GetMapping("{id}")
    public ResponseResult getUsersEntityId(@PathVariable("id") int id){
        return ResponseResult.success(usersService.getUsersEntityById(id) ) ;
    }

    @GetMapping("put/{id}")
    public ResponseResult updateUsersEntityId(@PathVariable("id") int id){
        return ResponseResult.success(usersService.updateEntity(id)) ;
    }
}
