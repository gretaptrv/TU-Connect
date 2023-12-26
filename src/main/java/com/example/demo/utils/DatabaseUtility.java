package com.example.demo.utils;

import com.example.demo.models.Student;
import com.example.demo.models.Tutor;
import com.example.demo.models.User;
import com.example.demo.models.VisitingHours;
import com.example.demo.repos.StudentRepository;
import com.example.demo.repos.TutorRepository;
import com.example.demo.repos.VisitingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseUtility {
  private final TutorRepository tutorRepository;
  private final StudentRepository studentRepository;
  private final VisitingHoursRepository visitingHoursRepository;

  @Autowired
  public DatabaseUtility(TutorRepository tutorRepository, StudentRepository studentRepository, VisitingHoursRepository visitingHoursRepository) {
    this.tutorRepository = tutorRepository;
    this.studentRepository = studentRepository;
    this.visitingHoursRepository = visitingHoursRepository;
    this.initDatabase();
  }

  private void initDatabase() {
    System.out.println("------- DATABASE INIT ---------");
    List<Tutor> tutors = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<VisitingHours> hours = new ArrayList<>();
/*
    addTutors(tutors);
    addStudents(students);

    setLoginCredentials(tutors);
    setLoginCredentials(students);
    tutorRepository.saveAll(tutors);
    studentRepository.saveAll(students);

    addVisitingHours(hours);
    visitingHoursRepository.saveAll(hours);*/
  }


  private void setLoginCredentials(List<? extends User> users) {
    users.forEach(user -> {
      user.setPassword(user.getLastName() + "_" + user.getFirstName());
      user.setUsername(user.getEmail());
      //TODO: hash the password
    });
  }

  private void addTutors(List<Tutor> tutors) {
    tutors.add(new Tutor("Iva", "Nikolova", "02 965-2680", "inni@tu-sofia.bg", "1311"));
    tutors.add(new Tutor("Milena", "Lazarova", "02 965-2524", "milaz@tu-sofia.bg", "1201"));
    tutors.add(new Tutor("Boris", "Tudzharov", "02 965-3385", "bntv@tu-sofia.bg", "1203"));
    tutors.add(new Tutor("Daniela", "Gotseva", "02 965-2338", "dgoceva@tu-sofia.bg", "1204"));
    tutors.add(new Tutor("Ognyan", "Nakov", "02 965-2513", "nakov@tu-sofia.bg", "1443"));
    tutors.add(new Tutor("Adelina", "Aleksieva", "02 965-2652", "aaleksieva@tu-sofia.bg", "3311A"));
    tutors.add(new Tutor("Antonia", "Tasheva", "02 965-3471", "atasheva@tu-sofia.bg", "3417А"));
    tutors.add(new Tutor("Valentin", "Mollov", "02 965-3523", "mollov@tu-sofia.bg", "1200"));
    tutors.add(new Tutor("Valentin", "Hristov", "02 965-3054", "v_hristov@tu-sofia.bg", "1323A"));
    tutors.add(new Tutor("Georgi", "Zapryanov", "02 965-2680", "gszap@tu-sofia.bg", "1311"));
    tutors.add(new Tutor("Petar", "Marinov", "02 965-2224", "pmarinov@tu-sofia.bg", "1205"));
    tutors.add(new Tutor("Neven", "Nikolov", "", "n.nikolov@tu-sofia.bg", "1406"));
    tutors.add(new Tutor("Rumen", "Trifonov", "", "r_trifonov@tu-sofia.bg", "1326"));
    tutors.add(new Tutor("Galya", "Pavlova", "02 965-3523", "raicheva@tu-sofia.bg", "1200"));
    tutors.add(new Tutor("Diana", "Grigorova", "02 965-3523", "dgrigorova@tu-sofia.bg", "1200"));
    tutors.add(new Tutor("Yavor", "Tomov", "02 965-2224", "yavor_tomov@tu-sofia.bg", "1200"));
  }

  private void addStudents(List<Student> students) {
    students.add(new Student("121219115", "Greta", "Petrova", "greta.petrova@tu-sofia.bg", 29));
    students.add(new Student("121219012", "Valentina", "Andreeva", "valentina.andreeva@tu-sofia.bg", 30));
    students.add(new Student("121219057", "Slavena", "Dimitrova", "slavena.dimitrova@tu-sofia.bg", 30));
    students.add(new Student("121219071", "Jaqueline", "Basheva", "jaqueline.basheva@tu-sofia.bg", 30));
    students.add(new Student("121219041", "Miroslav", "Mihaylov", "miroslav.mihaylov@tu-sofia.bg", 29));
  }

  private void addVisitingHours(List<VisitingHours> hours) {
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Iva", "Nikolova"), Time.valueOf("12:00:00"), Time.valueOf("14:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Milena", "Lazarova"), Time.valueOf("09:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Boris", "Tudzharov"), Time.valueOf("13:00:00"), Time.valueOf("16:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Daniela", "Gotseva"), Time.valueOf("10:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Ognyan", "Nakov"), Time.valueOf("14:00:00"), Time.valueOf("17:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Adelina", "Aleksieva"), Time.valueOf("15:00:00"), Time.valueOf("17:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Antonia", "Tasheva"), Time.valueOf("09:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Valentin", "Mollov"), Time.valueOf("12:00:00"), Time.valueOf("14:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Valentin", "Hristov"), Time.valueOf("14:00:00"), Time.valueOf("16:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Georgi", "Zapryanov"), Time.valueOf("13:00:00"), Time.valueOf("15:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Petar", "Marinov"), Time.valueOf("11:00:00"), Time.valueOf("13:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Petar", "Marinov"), Time.valueOf("09:00:00"), Time.valueOf("11:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Rumen", "Trifonov"), Time.valueOf("15:00:00"), Time.valueOf("17:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Galya", "Pavlova"), Time.valueOf("16:00:00"), Time.valueOf("18:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Yavor", "Tomov"), Time.valueOf("10:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(tutorRepository.findByFirstNameAndLastName("Diana", "Grigorova"), Time.valueOf("10:00:00"), Time.valueOf("12:00:00")));
  }


/*  HikariCP - why?
  With connection pooling, when you call connection.close(), the connection is not actually closed;
  it"s returned to the connection pool for reuse by other parts of your application.
  This approach is more efficient and performs better
  than opening and closing a new connection for every database operation.*/
}