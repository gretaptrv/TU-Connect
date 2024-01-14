package com.example.demo.repos;

import com.example.demo.models.VisitingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Optional;

@Repository
public interface VisitingHoursRepository extends JpaRepository<VisitingHours, Integer> {

    @Query("SELECT vh FROM VisitingHours vh WHERE vh.start = :start AND vh.end = :end ")
    Optional<VisitingHours> findByStartAndEndTime(@Param("start") Time startTime, @Param("end") Time endTime);
}