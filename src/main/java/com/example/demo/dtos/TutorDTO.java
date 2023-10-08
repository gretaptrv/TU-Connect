package com.example.demo.dtos;

import com.example.demo.models.Schedule;
import com.example.demo.models.VisitingHours;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class TutorDTO {

  private String fkNum;

  private String firstName;

  private String lastName;

  private String phoneNum;

  private String email;

  private String roomNum;

  private String faculty;

  private List<Schedule> schedules;

  private VisitingHours visitingHours;

  public TutorDTO() {
  }

  public TutorDTO(String username, String password, String firstName, String lastName, String fkNum, String phoneNum, String email, String roomNum, String faculty) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.fkNum = fkNum;
    this.phoneNum = phoneNum;
    this.email = email;
    this.roomNum = roomNum;
    this.faculty = faculty;
  }
}
