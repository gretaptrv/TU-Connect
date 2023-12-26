package com.example.demo.repos;

import com.example.demo.models.Faculty;
import com.example.demo.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

    Optional<Tutor> findByFirstName(String firstName);

    List<Tutor> findAll();

    List<Tutor> findAllByFaculty(Faculty faculty);

    @Query("SELECT t FROM Tutor t WHERE t.username = :username")
    Optional<Tutor> findByUsername(@Param("username") String username);

    Optional<Tutor> findByFirstNameAndLastName(String firstName, String lastName);
}