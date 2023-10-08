package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "STUDENT")
@Getter
@NoArgsConstructor
public class Student extends User {
  @Column(name = "GROUP_NUM")
  private int groupNum;

  public Student(String fkNum, String firstName, String lastName, String email, int groupNum) {
    super(fkNum, firstName, lastName, email);
    this.groupNum = groupNum;

  }
}
