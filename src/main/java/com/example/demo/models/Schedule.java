package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.sql.Time;

@Entity 
@Table(name = "SCHEDULE")
public class Schedule {
  @Id
  @Column(name = "ID")
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

  @Column(name = "TUTOR_FN")
  private String tutorFN;

  //TODO: добави курс на студентите

  @Column(name = "GROUP_NUM")
  private int groupNum;
}

