package com.toy.chatapp.service;


import com.toy.chatapp.model.UserLogin;
import com.toy.chatapp.repo.UserLoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService
{

    @Autowired
    UserLoginRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserLogin register(UserLogin user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
