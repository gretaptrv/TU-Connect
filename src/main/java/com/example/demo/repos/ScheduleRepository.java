package com.example.demo.repos;

import com.example.demo.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByTutorFN(String tutorFk);

    List<Schedule> findAll();
}