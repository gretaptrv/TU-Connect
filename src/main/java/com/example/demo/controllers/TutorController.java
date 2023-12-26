package com.example.demo.controllers;

import com.example.demo.models.Tutor;
import com.example.demo.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

	private final TutorService tutorService;

	@Autowired
	public TutorController(TutorService tutorService) {
		this.tutorService = tutorService;
	}

	@GetMapping
	public ResponseEntity<List<Tutor>> getAllTutors() {
		List<Tutor> tutors = tutorService.getAll();
		return new ResponseEntity<>(tutors, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
		Tutor tutor = tutorService.getById(id).orElse(null);
		return new ResponseEntity<>(tutor, HttpStatus.OK);
	}

}
