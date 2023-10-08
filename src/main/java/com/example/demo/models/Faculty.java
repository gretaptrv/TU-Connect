package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity 
@Table(name = "FACULTY")
public class Faculty {
  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACULTY_SEQ")
  @SequenceGenerator(name = "FACULTY_SEQ", sequenceName = "FACULTY_SEQ", allocationSize = 1)
  private Long id;

  @Column(name = "NAME")
  private String name;
}

