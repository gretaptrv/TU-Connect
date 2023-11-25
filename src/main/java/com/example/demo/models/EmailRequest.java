package com.example.demo.models;

import lombok.Data;

@Data
public class EmailRequest {

  private final String recipientEmail;
  private final String subject;
  private final String message;
}
