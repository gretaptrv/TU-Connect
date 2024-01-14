package com.example.demo.services;

import com.example.demo.models.VisitingHours;
import com.example.demo.repos.VisitingHoursRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Optional;

@Service
public class VisitingHoursService {

  VisitingHoursRepository visitingHoursRepository;

  public Optional<VisitingHours> findByStartAndEndTime(Time start, Time end) {
    return visitingHoursRepository.findByStartAndEndTime(start, end);
  }

  public VisitingHours save(VisitingHours newVisitingHours) {
    return visitingHoursRepository.save(newVisitingHours);
  }
}
