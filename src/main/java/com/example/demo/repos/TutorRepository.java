package com.example.demo.repos;

import com.example.demo.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByFkNum(String fk);

    List<Tutor> findAll();

    List<Tutor> findAllByFaculty(String faculty);
}