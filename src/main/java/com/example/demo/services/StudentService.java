package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  @Autowired
  StudentRepository students;

  public List<Student> getAll() {
    return students.findAll();
  }

  public Optional<Student> getById(String fkNum) {
    return students.findByFkNum(fkNum);
  }

  public Student getByUsername(String username) {
    Optional<Student> optionalStudent = students.findByUsername(username);
    return optionalStudent.orElse(null);
  }

  public void save(Student student) {
    students.save(student);
  }
}
