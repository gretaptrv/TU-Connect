package com.example.demo.services;

import com.example.demo.models.UserData;
import com.example.demo.models.User;
import com.example.demo.models.AuthRequest;
import com.example.demo.config.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;
  private final TutorService tutorService;
  private final StudentService studentService;
  PasswordEncoder passwordEncoder;

  @Autowired
  public AuthenticationService(AuthenticationManager authenticationManager, JwtUtils jwtUtils, TutorService tutorService, StudentService studentService, PasswordEncoder passwordEncoder) {
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
    this.tutorService = tutorService;
    this.studentService = studentService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = tutorService.getByUsername(username);
    if (user == null && (user = studentService.getByUsername(username)) == null) {
      return null;
    }
    return new UserData(user);
  }

  public String authenticate(AuthRequest authRequest) {
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    if (authentication.isAuthenticated()) {
      return jwtUtils.generateToken(authRequest.getUsername());
    }
    throw new UsernameNotFoundException("Invalid username or password!");
  }
}
