package com.example.demo.services;

import com.example.demo.models.Tutor;
import com.example.demo.models.VisitingHours;
import com.example.demo.repos.VisitingHoursRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitingHoursService {

  VisitingHoursRepository visitingHoursRepository;

  public VisitingHours getByTutor(Tutor tutor) {
    return visitingHoursRepository.findByTutor(tutor);
  }
}
