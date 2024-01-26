package com.example.demo.models;

import com.example.demo.enums.status.ThesisStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "THESIS")
public class Thesis {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @Setter(AccessLevel.PRIVATE)
  @Column(name = "STATUS")
  private ThesisStatus status = ThesisStatus.SUBMITTED;

  @Setter(AccessLevel.NONE)
  @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
  private List<ThesisOffer> thesisOffers = new ArrayList<>();

  public void pendingStatus() {
    this.status = ThesisStatus.PENDING;
  }

  public void acceptedStatus() {
    this.status = ThesisStatus.ACCEPTED;
    deleteOffers();
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

  public void addOffer(ThesisOffer offer) {
    this.thesisOffers.add(offer);
  }

  private void deleteOffers() {
    this.thesisOffers.clear();
  }

  public void deleteOffer(ThesisOffer offer) {
    this.thesisOffers.remove(offer);
  }
}

