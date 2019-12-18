package com.example.redis.controller;

import com.example.redis.pojo.User;
import com.example.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raintrees
 * @date 2019/12/17 17:29
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value ="/queryById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id")Integer id){
        User user=userService.queryUserById(id);
        HttpStatus status = user == null ? HttpStatus.NOT_FOUND :HttpStatus.OK;
        return new ResponseEntity<User>(user,status);
    }

}
