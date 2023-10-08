package com.example.demo.dtos;

import java.sql.Time;

public class BookedMeetingDto {

  private Long tutorFN;
  private Long studentFN;
  private Time start;
  private Time end;
  private int roomNum;
  private String reason;

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

}

