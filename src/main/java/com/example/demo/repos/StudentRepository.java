package com.example.demo.repos;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  @Query("SELECT st FROM Student st WHERE st.username = :username")
  Optional<Student> findByUsername(@Param("username") String username);

  Optional<Student> findByFkNum(String fkNum);
}