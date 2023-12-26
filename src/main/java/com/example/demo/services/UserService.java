package com.example.demo.services;

import com.example.demo.auth.UserData;
import com.example.demo.enums.UserRole;
import com.example.demo.models.Student;
import com.example.demo.models.Tutor;
import com.example.demo.models.User;
import com.example.demo.utils.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements UserDetailsService {

  private final TutorService tutors;
  private final StudentService students;
  private final StudentService studentService;
  PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(TutorService tutors, StudentService students, StudentService studentService, PasswordEncoder passwordEncoder) {
    this.tutors = tutors;
    this.students = students;
    this.studentService = studentService;
    this.passwordEncoder = passwordEncoder;
  }

  public List<User> list() {
    Stream<User> allUsersStream = Stream.concat(
        tutors.getAll().stream().map(user -> (User) user),
        students.getAll().stream().map(user -> (User) user)
    );

    return allUsersStream.collect(Collectors.toList());
  }

  public User getByUsernameAndPassword(String username, String password) {
    User user = tutors.getByUsername(username);
    if (user == null && (user = studentService.getByUsername(username)) == null) {
      return null;
    }
    if (BCrypt.checkpw(password, user.getPassword())) {
      return user;
    }
    return null;
  }

  public boolean checkUsername(String username) {
    User user = tutors.getByUsername(username);
    return user == null && (user = studentService.getByUsername(username)) == null;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = tutors.getByUsername(username);
    if (user == null && (user = studentService.getByUsername(username)) == null) {
      return null;
    }
    return new UserData(user);
  }

  public void addUser(AuthRequest authRequest) {
    if (authRequest.getRole() == UserRole.STUDENTE) {
      students.save(Student
                        .builder()
                        .fkNum("1235_789")
                        .username(authRequest.getUsername())
                        .password(passwordEncoder.encode(authRequest.getPassword()))
                        .build()
      );
    } else {
      tutors.save(Tutor
                      .builder()
                      .username(authRequest.getUsername())
                      .password(passwordEncoder.encode(authRequest.getPassword()))
                      .build()
      );
    }
  }
}
