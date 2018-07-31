package com.example.swagger.controller;

import com.example.swagger.model.User;
import com.example.swagger.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @author wensiao
 * @create 2018-07-30 11:15
 **/
@RestController
@RequestMapping(value="/users")     // 通过这里配置使下面的映射都在/users下，可去除
@Api(description = "基础增删改查接口")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @ApiOperation(value="获取用户列表", notes="")
    @GetMapping(value={""})
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping(value="")
    public User postUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path",allowableValues = "1,2")
    @GetMapping(value="/{id}")
    public Optional<User> getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping(value="/{id}")
    public int putUser(@PathVariable Integer id, @RequestBody User user) {

        return userRepository.updateStatusById(user.getName(),user.getAge(),id);
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping(value="/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

}