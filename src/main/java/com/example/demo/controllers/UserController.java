package com.example.demo.controllers;

import com.example.demo.models.AuthRequest;
import com.example.demo.models.User;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.UserService;
import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final AuthenticationService authService;

    @Autowired
    public UserController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("test")
    public String hello() {
        return "Hello world";
    }

    @PostMapping("/register")
    public void register(@RequestBody AuthRequest authRequest) {
        this.userService.addUser(authRequest);
    }

    @PostMapping("/login")
    public String authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
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

    @ExceptionHandler({SignatureException.class, ClaimJwtException.class, JwtException.class, DecodingException.class, AuthenticationException.class})
    public ResponseEntity<String> handle(Exception e) {
        return new ResponseEntity<>("An authorization error occurred, check your request and try again.", HttpStatus.UNAUTHORIZED);
    }
}