package com.example.demo.services;

import com.example.demo.models.Schedule;
import com.example.demo.models.Tutor;
import com.example.demo.dtos.TutorDTO;
import com.example.demo.models.VisitingHours;
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

  public List<Tutor> getAll() {
    return tutors.findAll();
  }

  public Optional<Tutor> getById(String fkNum) {
    return tutors.findByFkNum(fkNum);
  }

  public List<Tutor> getAllByFaculty(String faculty) {
    return tutors.findAllByFaculty(faculty);
  }

  public TutorDTO mapTutor(Tutor tutor) {
    TutorDTO tut = new TutorDTO();
    tut.setFaculty(tutor.getFaculty());
    tut.setPhoneNum(tutor.getPhoneNum());
    tut.setEmail(tutor.getEmail());
    tut.setSchedules(this.getSchedules(tutor.getFkNum()));

    return tut;
  }

  public List<Schedule> getSchedules(String tutorFN) {
    return scheduleService.getByTutor(tutorFN);
  }

  public VisitingHours getVisitingHours(String tutorFN) {
    return visitingHoursService.getByTutor(tutorFN);
  }

}
