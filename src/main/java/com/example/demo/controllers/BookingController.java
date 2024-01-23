package com.example.demo.controllers;

import com.example.demo.models.BookedMeeting;
import com.example.demo.models.Student;
import com.example.demo.models.Tutor;
import com.example.demo.services.BookingService;
import com.example.demo.services.StudentService;
import com.example.demo.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

  @Autowired
  private BookingService bookingService;

  @Autowired
  private StudentService studentService;

  @Autowired
  private TutorService tutorService;

  @GetMapping("/student/{studentId}")
  @Secured({"STUDENTE"})
  public ResponseEntity<List<BookedMeeting>> getMeetingsForStudent(@PathVariable Long studentId) {
    Student student = studentService.getById(studentId).orElseThrow(() -> new DataRetrievalFailureException("Could not find information about student."));
    List<BookedMeeting> meetings = bookingService.getAllMeetingsForStudent(student);
    return ResponseEntity.ok(meetings);
  }

  @GetMapping("/tutor/{tutorId}")
  @Secured({"TUTORE"})
  public ResponseEntity<List<BookedMeeting>> getMeetingsForTutor(@PathVariable Long tutorId) {
    Tutor tutor = tutorService.getById(tutorId).orElseThrow(() -> new DataRetrievalFailureException("Could not find information about tutor."));
    List<BookedMeeting> meetings = bookingService.getAllMeetingsForTutor(tutor);
    return ResponseEntity.ok(meetings);
  }

  @PostMapping("/book")
  @Secured({"STUDENTE"})
  public ResponseEntity<BookedMeeting> bookMeeting(@RequestBody BookedMeeting meeting) {
    BookedMeeting bookedMeeting = bookingService.bookMeeting(meeting);
    return ResponseEntity.ok(bookedMeeting);
  }

  @PostMapping("/accept/meeting/{meetingId}")
  @Secured({"TUTORE"})
  public ResponseEntity<BookedMeeting> acceptMeeting(@PathVariable Long meetingId) {
    BookedMeeting meeting = bookingService.acceptMeeting(meetingId);
    return ResponseEntity.ok(meeting);
  }

  @PostMapping("/acceptWithChanges/meeting/{meetingId}")
  @Secured({"TUTORE"})
  public ResponseEntity<BookedMeeting> acceptMeetingWithChanges(@PathVariable Long meetingId, @RequestBody BookedMeeting updatedMeeting) {
    BookedMeeting meeting = bookingService.acceptMeetingWithChanges(meetingId, updatedMeeting);
    return ResponseEntity.ok(meeting);
  }

  @PostMapping("/decline/meeting/{meetingId}")
  @Secured({"TUTORE"})
  public ResponseEntity<Void> declineMeeting(@PathVariable Long meetingId) {
    bookingService.declineMeeting(meetingId);
    return ResponseEntity.ok().build();
  }
}
