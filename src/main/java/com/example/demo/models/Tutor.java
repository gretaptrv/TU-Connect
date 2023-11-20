package com.example.demo.models;

import com.example.demo.enums.UserRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "TUTOR")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Tutor extends User {

  @Column(name = "PHONE_NUM", length = 11)
  private String phoneNum;

  @Column(name = "ROOM_NUM", length = 5)
  private String roomNum;

  @Column(name = "FACULTY")
  private String faculty;

  @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
  private List<Thesis> theses;

  @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
  private List<VisitingHours> visitingHours;

  @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
  private List<Schedule> schedule;

  public Tutor(String fakNum, String firstName, String lastName, String phoneNum, String email, String roomNum, String faculty) {
    super(fakNum, firstName, lastName, email);
    this.phoneNum = phoneNum;
    this.roomNum = roomNum;
    this.faculty = faculty;
  }

  @Override
  UserRole getRole() {
    return UserRole.TUTORE;
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

  //TODO: add a picture url and a default picture
}
