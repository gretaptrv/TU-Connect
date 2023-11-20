package com.example.demo.repos;

import com.example.demo.models.Tutor;
import com.example.demo.models.VisitingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitingHoursRepository extends JpaRepository<VisitingHours, Integer> {

    VisitingHours findByTutor(Tutor tutor);
}