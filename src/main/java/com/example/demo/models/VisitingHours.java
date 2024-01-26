package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "VISITING_HOURS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"START_TIME", "END_TIME"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VisitingHours {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @NonNull
  @Column(name = "START_TIME")
  private Time start;

  @NonNull
  @Column(name = "END_TIME")
  private Time end;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    VisitingHours that = (VisitingHours) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}

