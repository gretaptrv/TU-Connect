package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TUTOR")
@Getter
@NoArgsConstructor
public class Tutor extends User {

  @Column(name = "PHONE_NUM", length = 11)
  private String phoneNum;

  @Column(name = "ROOM_NUM", length = 5, nullable = false)
  private String roomNum;

  @Column(name = "FACULTY", nullable = false)
  private String faculty;

  public Tutor(String fakNum, String firstName, String lastName, String phoneNum, String email, String roomNum, String faculty) {
    super(fakNum, firstName, lastName, email);
    this.phoneNum = phoneNum;
    this.roomNum = roomNum;
    this.faculty = faculty;

  }

  //TODO: add a picture url and a default picture
}
