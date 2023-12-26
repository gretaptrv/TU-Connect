package com.example.demo.models;

import com.example.demo.enums.status.MeetingStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Time;

@Data
@Entity 
@Table(name = "BOOKED_MEETING")
public class BookedMeeting {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "TUTOR_FN")
  private Tutor tutor;

  @ManyToOne
  @JoinColumn(name = "STUDENT_FN")
  private Student student;

  @Column(name = "START_TIME")
  private Time start;

  @Column(name = "END_TIME")
  private Time end;

  @Column(name = "ROOM_NUM")
  private int roomNum;

  @Column(name = "REASON")
  private String reason;

  @Column(name = "STATUS")
  private MeetingStatus status;

}

