package com.meli.desafiospring.controller;

import com.meli.desafiospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;

    @RequestMapping(value = "{userId}/follow/{userIdToFollow}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        service.follow(userId,userIdToFollow);
    }
}
