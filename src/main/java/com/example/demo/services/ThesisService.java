package com.example.demo.services;

import com.example.demo.enums.email.Subject;
import com.example.demo.models.EmailRequest;
import com.example.demo.models.Thesis;
import com.example.demo.models.ThesisOffer;
import com.example.demo.repos.ThesisOfferRepository;
import com.example.demo.repos.ThesisRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ThesisService {

  private final ThesisRepository thesisRepository;
  private final ThesisOfferRepository offerRepository;
  private final EmailService emailService;

  @Autowired
  public ThesisService(ThesisRepository thesisRepository, ThesisOfferRepository offerRepository, EmailService emailService) {
    this.thesisRepository = thesisRepository;
    this.offerRepository = offerRepository;
    this.emailService = emailService;
  }

  public void save(Thesis thesis) {
    this.thesisRepository.save(thesis);
  }

  public void save(ThesisOffer offer) {
    this.offerRepository.save(offer);
  }

  public ResponseEntity<String> addOffer(ThesisOffer thesisOffer) {
    Thesis thesis = thesisOffer.getThesis();
    if (thesis != null) {
      thesis.pendingStatus();
      thesis.addOffer(thesisOffer);

      /* TODO: Which one should be saved first? */
      save(thesisOffer);
      save(thesis);

      /* TODO */
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

}
