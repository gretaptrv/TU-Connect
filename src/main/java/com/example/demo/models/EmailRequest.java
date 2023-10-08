package com.example.demo.models;

public class EmailRequest {

  private String recipientEmail;
  private String subject;
  private String message;

  public String getRecipientEmail() {
    return this.recipientEmail;
  }

  public String getSubject() {
    return this.subject;
  }

  public String getMessage() {
    return this.message;
  }
}
