package com.example.demo.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity 
@Table(name = "SCHEDULE")
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "DAY")
  private String dayOfWeek;

  @Column(name = "STARTING_TIME")
  private Time start;

  @Column(name = "END_TIME")
  private Time end;

  @Column(name = "ROOM_NUM")
  private int roomNum;

  @OneToMany(mappedBy = "schedule")
  private List<Tutor> tutors;
  //TODO: impossible, change to one tutor

}

