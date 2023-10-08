package com.example.demo.controllers;

import com.example.demo.models.EmailRequest;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

  private final EmailService emailService;

  @Autowired
  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping("/send-email")
  public void sendEmail(@RequestBody EmailRequest emailRequest) {
    String recipientEmail = emailRequest.getRecipientEmail();
    String subject = emailRequest.getSubject();
    String message = emailRequest.getMessage();
    emailService.sendEmail(recipientEmail, subject, message);
  }
}

