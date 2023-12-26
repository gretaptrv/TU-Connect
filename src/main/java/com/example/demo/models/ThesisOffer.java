package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "THESIS_OFFER")
public class ThesisOffer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "TUTOR_EMAIL", nullable = false)
  private String tutorEmail;

  @Column(name = "NOTE")
  private String note;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "THESIS_ID")
  private Thesis thesis;

  // Constructors, getters, and setters
}

