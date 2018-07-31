package com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author wensiao
 * @create 2018-07-30 11:28
 **/
@RestController
@Api(description = "忽略注解测试接口")
public class IgnoreTestController {

    @ApiOperation(value="测试忽略注解,ignore")
    @ApiIgnore
    @GetMapping("/Ignore")
    public String ignore(){
        return "This Api was ignored.";
    }

    @ApiOperation(value="测试忽略注解,notIgnore")
    @GetMapping("/NotIgnore")
    public String notIgnore() {
        return "Now,this Api isn't ignored.";
    }
}
