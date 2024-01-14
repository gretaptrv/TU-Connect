package com.example.demo.controllers;

import com.example.demo.enums.email.Subject;
import com.example.demo.models.EmailRequest;
import com.example.demo.models.Thesis;
import com.example.demo.models.ThesisOffer;
import com.example.demo.services.EmailService;
import com.example.demo.services.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thesis")
public class ThesisController {

    private final ThesisService thesisService;
    private final EmailService emailService;

    @Autowired
    public ThesisController(ThesisService thesisService, EmailService emailService) {
        this.thesisService = thesisService;
        this.emailService = emailService;
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitThesis(@RequestBody Thesis thesis) {
        thesisService.save(thesis);
        return new ResponseEntity<>("Thesis submitted successfully", HttpStatus.CREATED);
    }

    @PostMapping("/offer")
    public ResponseEntity<String> addThesisOffer(@RequestBody ThesisOffer thesisOffer) {
        return thesisService.addOffer(thesisOffer);
    }

    @PostMapping("/accept/{thesisOfferId}")
    public ResponseEntity<String> acceptRequest(@RequestBody String emailContent, @PathVariable Long thesisOfferId) {

        ThesisOffer offer = thesisService.getOffer(thesisOfferId);
        if (offer != null) {

            Thesis thesis = offer.getThesis();
            thesis.acceptedStatus();
            EmailRequest request = new EmailRequest
                (offer.getTutorEmail(), Subject.OFFER_ACCEPTED.getMessage(), emailContent);
            emailService.sendEmail(request);

            thesisService.save(thesis);
            thesisService.save(offer);

            return new ResponseEntity<>("Thesis request accepted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Thesis not found", HttpStatus.NOT_FOUND);
        }
    }
}
