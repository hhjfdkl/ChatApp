package com.toy.chatapp.controllers;

import com.toy.chatapp.model.UserLogin;
import com.toy.chatapp.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController
{

    @Autowired
    private UserLoginService service;

    @PostMapping("/register")
    public UserLogin register(@RequestBody UserLogin user)
    {
        return service.register(user);
    }
}
