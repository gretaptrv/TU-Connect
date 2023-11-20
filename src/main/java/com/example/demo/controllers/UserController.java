package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.example.demo.utils.AuthRequest;
import com.example.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
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
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtUtils.generateToken(authRequest.getUsername());
        }
        throw new UsernameNotFoundException("Invalid username or password!");
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