package com.example.demo.services;

import com.example.demo.models.Schedule;
import com.example.demo.models.Tutor;
import com.example.demo.models.VisitingHours;
import com.example.demo.repos.FacultyRepository;
import com.example.demo.repos.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
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

  public Tutor assignVisitingHours(Tutor tutor, Time start, Time end) {
    VisitingHours visitingHours = visitingHoursService.findByStartAndEndTime(start, end)
                                                         .orElseGet(() -> {
                                                           VisitingHours newVisitingHours = new VisitingHours();
                                                           newVisitingHours.setStart(start);
                                                           newVisitingHours.setEnd(end);
                                                           return visitingHoursService.save(newVisitingHours);
                                                         });

    tutor.setVisitingHours(visitingHours);
    return tutors.save(tutor);
  }

  public void save(Tutor tutor) {
    tutors.save(tutor);
  }
}
