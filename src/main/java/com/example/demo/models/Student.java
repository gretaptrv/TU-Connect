package com.example.demo.models;

import com.example.demo.enums.UserRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "STUDENT")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Student extends User {
  @Column(name = "GROUP_NUM")
  private int groupNum;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Thesis> theses;

  @Id
  @Column(name = "FK_NUM", length = 9, unique = true)
  private String fkNum;

  public Student(String fkNum, String firstName, String lastName, String email, int groupNum) {
    super(firstName, lastName, email);
    this.fkNum = fkNum;
    this.groupNum = groupNum;
  }

  @Override
  UserRole getRole() {
    return UserRole.STUDENTE;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
