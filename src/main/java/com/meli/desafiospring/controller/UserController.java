package com.meli.desafiospring.controller;

import com.meli.desafiospring.domain.User;
import com.meli.desafiospring.dto.FollowerCountDTO;
import com.meli.desafiospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping("{userId}/follow/{userIdToFollow}")
    @ResponseStatus(HttpStatus.OK)
    public void followUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        service.follow(userId,userIdToFollow);
    }

    @GetMapping("{userId}/followers/count")
    @ResponseStatus(HttpStatus.OK)
    public FollowerCountDTO getUsers(@PathVariable Integer userId) {
        return service.followCount(userId);
    }
}
