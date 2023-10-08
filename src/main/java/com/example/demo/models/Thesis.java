package com.example.demo.models;

import com.example.demo.enums.thesis.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "THESIS")
public class Thesis {
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "THESIS_SEQ")
  @SequenceGenerator(name = "THESIS_SEQ", sequenceName = "THESIS_SEQ", allocationSize = 1)
  private Long id;

  @Column(name = "CONTENT", nullable = false)
  private String content;

  /*
  The email which will receive a notification
  when the thesis is accepted by a tutor.
   */
  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "STUDENT_FN")
  private String studentFN = null;

  @Column(name = "STATUS")
  private Status status = Status.DRAFT;

  public String getStudentFN() {
    return studentFN;
  }

  public void setStudentFN(String studentFN) {
    this.studentFN = studentFN;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void pendingStatus() {
    this.status = Status.PENDING;
  }

  public void acceptedStatus() {
    this.status = Status.ACCEPTED;
  }

}

