package com.toy.chatapp.repo;

import com.toy.chatapp.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer> {

    UserLogin findByUsername(String username);

}
