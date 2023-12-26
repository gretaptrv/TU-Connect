package com.example.demo.repos;

import com.example.demo.models.Tutor;
import com.example.demo.models.VisitingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitingHoursRepository extends JpaRepository<VisitingHours, Integer> {

    @Query("SELECT vh FROM VisitingHours vh JOIN vh.tutors t WHERE t = :tutor")
    VisitingHours findByTutor(@Param("tutor") Tutor tutor);
}