package com.toy.chatapp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//This class is just for testing API endpoints, not for release in production
@RestController
public class TestController {

    private final List<String> greetings = new ArrayList<>(List.of("Hello!", "Hello, world!", "Third Greeting", "Salutations!"));

    @GetMapping("/greetings")
    public List<String> getGreetings()
    {
        return greetings;
    }

    /**
     * CSRF tokens are used to prevent cross-site request forgery attacks
     *
     */
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request)
    {
        //the _csrf attribute you can check in the browser via "view source" during your session
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/greetings")
    public String addGreeting(@RequestBody String greeting)
    {
        greetings.add(greeting);
        return greeting;
    }
}
