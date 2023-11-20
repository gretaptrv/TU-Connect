package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.util.Optional;

@Entity
@Table(name = "VISITING_HOURS")
@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class VisitingHours {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "TUTOR_ID")
  private Tutor tutor;

  @NonNull
  @Column(name = "START_TIME")
  private Time start;

  @NonNull
  @Column(name = "END_TIME")
  private Time end;

  public VisitingHours(Optional<Tutor> tutor, Time start, Time end) {
    if (tutor.isEmpty() || end.before(start)) {
      throw new IllegalArgumentException("Error when creating VisitingHours!");
    }
    this.tutor = tutor.get();
    this.start = start;
    this.end = end;
  }
}

