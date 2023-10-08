package com.example.demo.models;

import com.example.demo.enums.booked.meeting.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.sql.Time;

@Entity 
@Table(name = "BOOKED_MEETING")
public class BookedMeeting {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "TUTOR_FN")
  private Long tutorFN;

  @Column(name = "STUDENT_FN")
  private Long studentFN;

  @Column(name = "START_TIME")
  private Time start;

  @Column(name = "END_TIME")
  private Time end;

  @Column(name = "ROOM_NUM")
  private int roomNum;

  @Column(name = "REASON")
  private String reason;

  @Column(name = "STATUS")
  private Status status;

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

  public int getRoomNum() {
    return roomNum;
  }

  public void setRoomNum(int roomNum) {
    this.roomNum = roomNum;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Long getTutorFN() {
    return tutorFN;
  }

  public void setTutorFN(Long tutorFN) {
    this.tutorFN = tutorFN;
  }

  public Long getStudentFN() {
    return studentFN;
  }

  public void setStudentFN(Long studentFN) {
    this.studentFN = studentFN;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}

