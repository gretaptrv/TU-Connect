package com.example.demo.controllers;

import com.example.demo.dtos.BookedMeetingDto;
import com.example.demo.models.Thesis;
import com.example.demo.services.ScheduleService;
import com.example.demo.services.TutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * All endpoints that are used to send information.
 */
@RestController
public class SendController {

	TutorService tutorService;
	ScheduleService scheduleService;

	@PostMapping(path = "/thesis-idea",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity sendThesisIdea(@RequestBody Thesis thesisContent) {
		return new ResponseEntity<>(thesisContent, HttpStatus.CREATED);
	}

	@PostMapping(path = "/tutors/tutor/timeblock")
	public ResponseEntity timeBlock(@RequestBody BookedMeetingDto meeting){
		// TODO
		return (ResponseEntity) ResponseEntity.ok();
	}

}