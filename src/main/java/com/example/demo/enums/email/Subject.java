package com.example.demo.enums.email;

public enum Subject {
  THESIS_OFFER("A new offer for your thesis has been made!"),
  OFFER_ACCEPTED("A student accepted your offer for thesis help!"),
  MEETING_REQUESTED("A student has requested a meeting with you!"),
  MEETING_ACCEPTED("Your meeting with a tutor was accepted!"),
  MEETING_DECLINED("Your tutor is busy and declined the meeting!");

  private final String message;

  public String getMessage() {
    return message;
  }

  Subject(String message) {
    this.message = message;
  }
}
