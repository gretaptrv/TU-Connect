package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.example.demo.utils.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/register")
    public void register(@RequestBody AuthRequest authRequest) {
        this.userService.addUser(authRequest);
    }

    @PostMapping
    public String authenticate(@RequestBody AuthRequest authRequest) {
        return userService.authenticate(authRequest);
    }

    @GetMapping
    @Secured({})
    public List<User> all() {
        return userService.list();
    }

    @GetMapping("/student")
    @Secured({"STUDENTE"})
    public String student(@AuthenticationPrincipal UserDetails userDetails) {
        return "Hello student " + userDetails.getUsername();
    }

    @GetMapping("/tutor")
    @Secured({"TUTORE"})
    public String tutor(@AuthenticationPrincipal UserDetails userDetails) {
        return "Hello tutor " + userDetails.getUsername();
    }
}