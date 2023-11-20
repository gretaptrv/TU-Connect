package com.example.demo.repos;

import com.example.demo.models.BookedMeeting;
import com.example.demo.models.Student;
import com.example.demo.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookedMeeting, Long> {

    List<BookedMeeting> findAllByTutor(Tutor tutor);

    List<BookedMeeting> findAllByStudent(Student student);
}