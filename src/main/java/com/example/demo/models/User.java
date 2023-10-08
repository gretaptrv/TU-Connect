package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
public abstract class User {

  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @Id
  @NonNull
  @Column(name = "FK_NUM", length = 9, unique = true, nullable = false)
  private String fkNum;

  @NonNull
  @Column(name = "FIRST_NAME", nullable = false)
  private String firstName;

  @NonNull
  @Column(name = "LAST_NAME", nullable = false)
  private String lastName;

  @NonNull
  @Column(name = "EMAIL", unique = true, nullable = false)
  private String email;
}
