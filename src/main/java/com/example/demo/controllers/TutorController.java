package com.example.demo.controllers;

import com.example.demo.models.Tutor;
import com.example.demo.models.dtos.TutorDTO;
import com.example.demo.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tutors")
public class TutorController {

	private final TutorService tutorService;

	@Autowired
	public TutorController(TutorService tutorService) {
		this.tutorService = tutorService;
	}

	@GetMapping
	public ResponseEntity<List<TutorDTO>> getAllTutors() {
		List<TutorDTO> tutors = tutorService
				.getAll()
				.stream()
				.map(TutorDTO::convert)
				.collect(Collectors.toList());
		return new ResponseEntity<>(tutors, HttpStatus.OK);
	}

	@GetMapping("/tutor/{id}")
	@Secured({})
	public ResponseEntity<TutorDTO> getTutorById(@PathVariable Long id) {
		Tutor tutor = tutorService.getById(id).orElse(new Tutor());
		TutorDTO dto = TutorDTO.convert(tutor);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

}
