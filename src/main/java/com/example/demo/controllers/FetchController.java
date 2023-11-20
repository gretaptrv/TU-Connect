package com.example.demo.controllers;

import com.example.demo.models.Schedule;
import com.example.demo.models.Tutor;
import com.example.demo.services.ScheduleService;
import com.example.demo.services.TutorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All endpoints that are used to fetch information.
 */
@AllArgsConstructor
@RestController
public class FetchController {

	TutorService tutorService;
	ScheduleService scheduleService;

	@GetMapping("/")
	public String test() {
		return "Connected!";
	}

	@GetMapping("/tutors")
	public List<Tutor> getTutors() {
		return tutorService.getAll();
	}

	@GetMapping("/tutors/tutor/{fakNum}")
	public Tutor getTutorInfoById(@PathVariable String fakNum) {
		Tutor tut = tutorService.getById(fakNum).orElseThrow();
		//TODO: fetch
		// engaged with theses
		// from db
		return null;
	}

	@GetMapping("/tutors/faculty/{facultyId}")
	public List<Tutor> getTutorsByFaculty(@PathVariable String facultyName) {
		return tutorService.getAllByFaculty(facultyName);
	}

	@GetMapping("/schedules/tutor/{tutorFKN}")
	public List<Schedule> getSchedulesByTutor(@PathVariable String tutorFKN) {
		return scheduleService.getByTutor(tutorService.getById(tutorFKN).orElse(null));
	}

}