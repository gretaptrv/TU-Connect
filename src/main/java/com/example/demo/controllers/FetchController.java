package com.example.demo.controllers;

import com.example.demo.services.ScheduleService;
import com.example.demo.services.TutorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}