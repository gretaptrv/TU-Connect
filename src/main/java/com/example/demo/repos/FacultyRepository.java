package com.example.demo.repos;

import com.example.demo.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByName(String facultyName);
    Optional<Faculty> findByName(String facultyName);
}