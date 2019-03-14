package com.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/4/18.
 */
@RestController
public class HelloWorldController {

    @Autowired
    private GirlProperties girlProperties ;

    @RequestMapping(value = {"hello","hi"},method = RequestMethod.GET)
    public String helloWorld(){
        return girlProperties.toString() ;
    }

    @RequestMapping(value = "say/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return id.toString() ;
    }

    @RequestMapping(value="say",method = RequestMethod.GET)
    public String sayId(@RequestParam(value = "id",required = false ,defaultValue = "0")Integer id){
        return id.toString() ;
    }
}
