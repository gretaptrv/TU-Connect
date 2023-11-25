package com.example.demo.services;

import com.example.demo.models.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

  private final JavaMailSender javaMailSender;

  @Autowired
  public EmailService(JavaMailSender javaMailSender) {
    this.javaMailSender = javaMailSender;
  }

  public void sendEmail(EmailRequest request) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

    try {
      helper.setTo(request.getRecipientEmail());
      helper.setSubject(request.getSubject());
      helper.setText(request.getMessage(), false);
      javaMailSender.send(mimeMessage);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
