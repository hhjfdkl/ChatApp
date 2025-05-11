package com.toy.chatapp.service;

import com.toy.chatapp.model.UserLogin;
import com.toy.chatapp.model.UserLoginPrincipal;
import com.toy.chatapp.repo.UserLoginRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {



    @Autowired
    private UserLoginRepo repo;

    //TODO: This only checks whether username exists, but we should treat this the same if password is incorrect
    //We do get a 401 when password isn't correct, but user not found is treated differently because of this
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserLogin user = repo.findByUsername(username);
        if(user == null)
        {
            System.out.println("User not found"); //remove stout later & replace with logger if needed
            throw new UsernameNotFoundException("User was not found");
        }
        return new UserLoginPrincipal(user);
    }
}
