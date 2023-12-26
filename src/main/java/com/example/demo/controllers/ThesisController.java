package com.example.demo.controllers;

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

    @PostMapping("/accept")
    public ResponseEntity<String> acceptRequest(@RequestParam Long thesisId) {
        // Logic for sending email to the tutor, deleting requests, and changing status
        // You might want to create a separate service for email sending and handle the logic there

        // For simplicity, let's assume you have methods in the Thesis entity to handle these actions
        Thesis thesis = null;
        if (thesis != null) {
            // Send email to the tutor
            // thesis.sendEmailToTutor();

            thesis.acceptedStatus();
            //delete remaining requests

            // Save the updated thesis
            thesisService.save(thesis);

            return new ResponseEntity<>("Thesis request accepted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Thesis not found", HttpStatus.NOT_FOUND);
        }
    }
}
