package com.example.demo.repos;

import com.example.demo.models.BookedMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookedMeeting, Long> {

    List<BookedMeeting> findAllByTutorFN(Long tutorFk);

    List<BookedMeeting> findAllByStudentFN(Long studentFk);
}