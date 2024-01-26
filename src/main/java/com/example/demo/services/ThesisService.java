package com.example.demo.services;

import com.example.demo.enums.email.Subject;
import com.example.demo.enums.status.ThesisStatus;
import com.example.demo.models.*;
import com.example.demo.repos.StudentRepository;
import com.example.demo.repos.ThesisOfferRepository;
import com.example.demo.repos.ThesisRepository;
import com.example.demo.repos.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThesisService {

  private final ThesisRepository thesisRepository;
  private final ThesisOfferRepository offerRepository;
  private final EmailService emailService;
  private final StudentRepository studentRepository;
  private final TutorRepository tutorRepository;

  @Autowired
  public ThesisService(ThesisRepository thesisRepository, ThesisOfferRepository offerRepository, EmailService emailService, StudentRepository studentRepository, TutorRepository tutorRepository) {
    this.thesisRepository = thesisRepository;
    this.offerRepository = offerRepository;
    this.emailService = emailService;
    this.studentRepository = studentRepository;
    this.tutorRepository = tutorRepository;
  }

  public void save(Thesis thesis) {
    this.thesisRepository.save(thesis);
  }

  public void save(ThesisDto thesis) {
    Optional<Student> student = this.studentRepository.findByFkNum(thesis.getStudentId());
    Optional<Tutor> tutor = this.tutorRepository.findById(thesis.getTutorId());

    this.thesisRepository.save(new Thesis(2L, tutor.get(), student.get(), thesis.getContent(), thesis.getEmail(), ThesisStatus.SUBMITTED, new ArrayList<>()));
  }

  public void save(ThesisOffer offer) {
    this.offerRepository.save(offer);
  }

  public ResponseEntity<String> addOffer(ThesisOffer thesisOffer) {
    Thesis thesis = thesisOffer.getThesis();
    if (thesis != null) {
      thesis.pendingStatus();
      thesis.addOffer(thesisOffer);

      save(thesisOffer);
      save(thesis);

      EmailRequest request = new EmailRequest(thesisOffer.getThesis().getStudent().getEmail(), Subject.THESIS_OFFER.getMessage(), thesisOffer.getNote());
      this.emailService.sendEmail(request);

      return new ResponseEntity<>("Thesis request processed successfully", HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Thesis not found", HttpStatus.NOT_FOUND);
    }
  }

  public Thesis getThesis(Long id) {
    try {
      return thesisRepository.getReferenceById(id);
    } catch (EntityNotFoundException e) {
      return null;
    }
  }

  public ThesisOffer getOffer(Long id) {
    try {
      return offerRepository.getReferenceById(id);
    } catch (EntityNotFoundException e) {
      return null;
    }
  }

  public List<ThesisDto> getALL(){
    return thesisRepository.findAll().stream().map((thesis -> new ThesisDto(thesis.getTutor().getId(), thesis.getStudent().getFkNum(), thesis.getContent(), thesis.getEmail()))).collect(Collectors.toList());
  }
}
