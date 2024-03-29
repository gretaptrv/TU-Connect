package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

  @Bean
  public JavaMailSender javaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);
    mailSender.setUsername("diplomen.mail@gmail.com");
    mailSender.setPassword("ovsf alwr uqii xknn");


    Properties properties = mailSender.getJavaMailProperties();
    properties.put("mail.smtp.starttls.enable", "true");

    return mailSender;
  }
}
