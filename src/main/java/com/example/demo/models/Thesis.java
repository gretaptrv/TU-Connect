package com.example.demo.models;

import com.example.demo.enums.status.ThesisStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "THESIS")
public class Thesis {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "THESIS_SEQ")
  @SequenceGenerator(name = "THESIS_SEQ", sequenceName = "THESIS_SEQ", allocationSize = 1)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "TUTOR_ID")
  private Tutor tutor;

  @ManyToOne
  @JoinColumn(name = "STUDENT_FN")
  private Student student;

  @Column(name = "CONTENT", nullable = false)
  private String content;

  /*
  The email which will receive a notification
  when the thesis is accepted by a tutor.
   */
  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "STATUS")
  private ThesisStatus status = ThesisStatus.DRAFT;

  public void pendingStatus() {
    this.status = ThesisStatus.PENDING;
  }

  public void acceptedStatus() {
    this.status = ThesisStatus.ACCEPTED;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Thesis thesis = (Thesis) o;
    return id != null && Objects.equals(id, thesis.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}

