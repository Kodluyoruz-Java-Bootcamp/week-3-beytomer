package com.emlakcepte.controller;


import com.emlakcepte.model.User;
import com.emlakcepte.service.RealtyService;
import com.emlakcepte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RealtyService realtyService;

    @GetMapping()
    public List<User> getAll(){
        return userService.getAllUser();
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){

        //  UserService service=new UserService();
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping (value = "/{email}")
    public User getByEmail(@PathVariable String email){
        return userService.getByEmail(email);
    }
    //• Kullanıcı yaptığı aramaları kaydedebilmeli, listeleyebilmeli
    @PostMapping("/saveSearch")
    public void saveSearch(){
        userService.getAllUser().get(0).getSaveSearchList().addAll(realtyService.getAllByProvinceAndCountyList("İstanbul","Pendik"));
    }

}
