package com.example.demo.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Time;

@Entity 
@Table(name = "VISITING_HOURS")
@RequiredArgsConstructor
@NoArgsConstructor
public class VisitingHours {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NonNull
  @Column(name = "TUTOR_ID")
  private Long tutorId;

  @NonNull
  @Column(name = "START_TIME")
  private Time start;

  @NonNull
  @Column(name = "END_TIME")
  private Time end;

  public Long getTutorId() {
    return tutorId;
  }

  public void setTutorId(Long tutorId) {
    this.tutorId = tutorId;
  }

  public Time getStart() {
    return start;
  }

  public void setStart(Time start) {
    this.start = start;
  }

  public Time getEnd() {
    return end;
  }

  public void setEnd(Time end) {
    this.end = end;
  }

}

