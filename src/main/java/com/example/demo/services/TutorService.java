package com.example.demo.services;

import com.example.demo.models.Schedule;
import com.example.demo.models.Tutor;
import com.example.demo.models.VisitingHours;
import com.example.demo.repos.FacultyRepository;
import com.example.demo.repos.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

  @Autowired
  ScheduleService scheduleService;

  @Autowired
  VisitingHoursService visitingHoursService;

  @Autowired
  TutorRepository tutors;

  @Autowired
  FacultyRepository faculties;

  public List<Tutor> getAll() {
    return tutors.findAll();
  }

  public Optional<Tutor> getById(Long id) {
    return tutors.findById(id);
  }

  public List<Tutor> getAllByFaculty(String faculty) {
    return tutors.findAllByFaculty(faculties.findByName(faculty).orElse(null));
  }

  public Tutor getByUsername(String username) {
    Optional<Tutor> optionalTutor = tutors.findByUsername(username);
    return optionalTutor.orElse(null);
  }

  public List<Schedule> getSchedules(Long id) {
    return scheduleService.getByTutor(tutors.findById(id).orElse(null));
  }

  public VisitingHours getVisitingHours(Long id) {
    return visitingHoursService.getByTutor(getById(id).orElse(null));
  }

  public void save(Tutor tutor) {
    tutors.save(tutor);
  }
}
