package com.example.demo.services;

import com.example.demo.models.Schedule;
import com.example.demo.repos.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

  ScheduleRepository schedules;

  public List<Schedule> getByTutor(String tutorFk) {
    return schedules.findByTutorFN(tutorFk);
  }
}
