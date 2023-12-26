package com.example.demo.models;

import com.example.demo.enums.UserRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "TUTOR")
@Getter
@NoArgsConstructor
@SuperBuilder
public class Tutor extends User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "PHONE_NUM", length = 11)
  private String phoneNum;

  @Column(name = "ROOM_NUM", length = 5)
  private String roomNum;

  @ManyToOne
  @JoinColumn(name = "FACULTY_ID")
  private Faculty faculty;

  @Column(name = "FACULTY")
  private String facultyId;

  @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
  private List<Thesis> theses;

  @ManyToOne
  @JoinColumn(name = "VISITING_HOURS_ID")
  private VisitingHours visitingHours;

  @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
  private List<Schedule> schedule;

  public void setId(Long id) {
    this.id = id;
  }

  public Tutor(String firstName, String lastName, String phoneNum, String email, String roomNum) {
    super(firstName, lastName, email);
    this.phoneNum = phoneNum;
    this.roomNum = roomNum;
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
