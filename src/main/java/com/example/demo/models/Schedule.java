package com.example.demo.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity 
@Table(name = "SCHEDULE")
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHEDULE_SEQ")
  @SequenceGenerator(name = "SCHEDULE_SEQ", sequenceName = "SCHEDULE_SEQ", allocationSize = 1)
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

}

