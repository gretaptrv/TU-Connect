package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  private final JavaMailSender javaMailSender;

  @Autowired
  public EmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  public void sendEmail(String recipientEmail, String subject, String message) {
    SimpleMailMessage email = new SimpleMailMessage();
    email.setTo(recipientEmail);
    email.setSubject(subject);
    email.setText(message);
    javaMailSender.send(email);
  }
}
