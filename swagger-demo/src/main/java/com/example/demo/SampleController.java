package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sks on 2018/1/23.
 */
@RestController
@EnableAutoConfiguration
@Api(tags = "Demo相关api")
public class SampleController {

    @Value("${server.address}")
    private String address ;

    @Value("${server.port}")
    private String port ;

    @RequestMapping(value = "/sample/{id}",method = RequestMethod.GET)
    @ApiOperation(value="Get测试", notes="Get类型测试")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path", name = "id", value = "记录id", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType="query", name = "name", value = "记录名称", required = true, dataType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数有误"),
            @ApiResponse(code = 401, message = "未授权"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    ResponseEntity<List<User>> home(@PathVariable("id")String id,@RequestParam("name")String name){
//        try{
//            if(Integer.parseInt(id) > 10){
//                return "number" ;
//            }
//        }catch (Exception e){
//            return "error" ;
//        }
//        return "helloworld" ;
        List<User> list = new ArrayList<User>(){{new User();}} ;
        ResponseEntity entity = new ResponseEntity() ;
        entity.setData(list);
        return entity ;
    }

    @RequestMapping(value = "/sample",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value="POST测试", notes="POST类型测试")
    ResponseEntity testPost(@RequestBody UserInfoDTO userInfoDTO){
        UserInfoDTO[] ary = new UserInfoDTO[2] ;
        ary[0] = userInfoDTO ;
        ary[1] = userInfoDTO ;
        System.out.println(userInfoDTO);
        return new ResponseEntity(userInfoDTO) ;
    }
}
