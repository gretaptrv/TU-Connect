package com.example.demo.repos;

import com.example.demo.models.Schedule;
import com.example.demo.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByTutorsContaining(Tutor tutor);

    List<Schedule> findAll();
}