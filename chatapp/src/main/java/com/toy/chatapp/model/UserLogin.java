package com.toy.chatapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class UserLogin {


    //TODO: Restructure the entity to better suit this. Username likely should be an ID
    @Id
    private int uid;
    private String username;
    private String password;


    public UserLogin(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }


    public UserLogin() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserLogin userLogin = (UserLogin) o;
        return uid == userLogin.uid && Objects.equals(username, userLogin.username) && Objects.equals(password, userLogin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, password);
    }
}
