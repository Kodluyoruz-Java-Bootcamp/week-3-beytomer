package com.medium.mediumservice.controller;

import com.medium.mediumservice.model.User;
import com.medium.mediumservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUser();
    }
    @PostMapping
    public void create(@RequestBody User user){
        userService.createUser(user);
    }
}
