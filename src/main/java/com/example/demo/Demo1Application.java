package com.example.demo;

import com.example.demo.models.EmailRequest;
import com.example.demo.services.EmailService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class Demo1Application {
  private static final Logger LOG = LoggerFactory.getLogger(Demo1Application.class);
  @Autowired
  private EmailService emailService;

  public static void main(String[] args) {
    SpringApplication.run(Demo1Application.class, args);
  }

  @PostConstruct
  public void sendEmailOnStartup() {
    EmailRequest request = new EmailRequest("gweaverace@gmail.com", "diplomna rabota",
                                            "mnogo qk mail");
    emailService
        .sendEmail(request);
  }

}
