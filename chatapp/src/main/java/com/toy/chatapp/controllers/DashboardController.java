package com.toy.chatapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    /**
     * TODO:
     * construct the data we'll send to the front end for UI display here
     */
    @GetMapping("/")
    public String greeting(HttpServletRequest request)
    {
        return "Welcome to your homepage!\n\nYour session ID is: " + request.getSession().getId() +
                "\n\nRemember to check out the '/greetings' resource." +
                "\n\nHave a nice day!";
    }



}
