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

    addVisitingHours(hours);
    addTutors(tutors);
    addStudents(students);


    setLoginCredentials(tutors);
    setLoginCredentials(students);
    tutorRepository.saveAll(tutors);
    studentRepository.saveAll(students);
    visitingHoursRepository.saveAll(hours);
  }


  private void setLoginCredentials(List<? extends User> users) {
    users.forEach(user -> {
      user.setPassword(user.getFkNum() + "_" + user.getFirstName());
      user.setUsername(user.getEmail());
    });
  }

  private void addVisitingHours(List<VisitingHours> hours) {
    hours.add(new VisitingHours(191213546L, Time.valueOf("12:00:00"), Time.valueOf("14:00:00")));
    hours.add(new VisitingHours(191213566L, Time.valueOf("09:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(191212546L, Time.valueOf("13:00:00"), Time.valueOf("16:00:00")));
    hours.add(new VisitingHours(191213576L, Time.valueOf("10:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(191213446L, Time.valueOf("14:00:00"), Time.valueOf("17:00:00")));
    hours.add(new VisitingHours(191213456L, Time.valueOf("15:00:00"), Time.valueOf("17:00:00")));
    hours.add(new VisitingHours(191213356L, Time.valueOf("09:00:00"), Time.valueOf("12:00:00")));
    hours.add(new VisitingHours(191213457L, Time.valueOf("12:00:00"), Time.valueOf("14:00:00")));
    hours.add(new VisitingHours(191213476L, Time.valueOf("14:00:00"), Time.valueOf("16:00:00")));
    hours.add(new VisitingHours(191213486L, Time.valueOf("13:00:00"), Time.valueOf("15:00:00")));
    hours.add(new VisitingHours(191213488L, Time.valueOf("11:00:00"), Time.valueOf("13:00:00")));
    hours.add(new VisitingHours(191213856L, Time.valueOf("09:00:00"), Time.valueOf("11:00:00")));
    hours.add(new VisitingHours(191213886L, Time.valueOf("15:00:00"), Time.valueOf("17:00:00")));
    hours.add(new VisitingHours(191213156L, Time.valueOf("16:00:00"), Time.valueOf("18:00:00")));
    hours.add(new VisitingHours(191213334L, Time.valueOf("10:00:00"), Time.valueOf("12:00:00")));
  }

  private void addStudents(List<Student> students) {
    students.add(new Student("121219115", "Greta", "Petrova", "greta.petrova@tu-sofia.bg", 29));
    students.add(new Student("121219012", "Valentina", "Andreeva", "valentina.andreeva@tu-sofia.bg", 30));
    students.add(new Student("121219057", "Slavena", "Dimitrova", "slavena.dimitrova@tu-sofia.bg", 30));
    students.add(new Student("121219071", "Jaqueline", "Basheva", "jaqueline.basheva@tu-sofia.bg", 30));
    students.add(new Student("121219041", "Miroslav", "Mihaylov", "miroslav.mihaylov@tu-sofia.bg", 29));
  }

  private void addTutors(List<Tutor> tutors) {
    tutors.add(new Tutor("191213546", "Iva", "Nikolova", "02 965-2680", "inni@tu-sofia.bg", "1311", "Computer systems"));
    tutors.add(new Tutor("191213566", "Milena", "Lazarova", "02 965-2524", "milaz@tu-sofia.bg", "1201", "Computer systems"));
    tutors.add(new Tutor("191212546", "Boris", "Tudzharov", "02 965-3385", "bntv@tu-sofia.bg", "1203", "Computer Systems"));
    tutors.add(new Tutor("191213576", "Daniela", "Gotseva", "02 965-2338", "dgoceva@tu-sofia.bg", "1204", "Computer Systems"));
    tutors.add(new Tutor("191213446", "Ognyan", "Nakov", "02 965-2513", "nakov@tu-sofia.bg", "1443", "Computer Systems"));
    tutors.add(new Tutor("191213456", "Adelina", "Aleksieva", "02 965-2652", "aaleksieva@tu-sofia.bg", "3311A", "Computer Systems"));
    tutors.add(new Tutor("191213356", "Antonia", "Tasheva", "02 965-3471", "atasheva@tu-sofia.bg", "3417А", "Computer Systems"));
    tutors.add(new Tutor("191213457", "Valentin", "Mollov", "02 965-3523", "mollov@tu-sofia.bg", "1200", "Computer Systems"));
    tutors.add(new Tutor("191213476", "Valentin", "Hristov", "02 965-3054", "v_hristov@tu-sofia.bg", "1323A", "Computer Systems"));
    tutors.add(new Tutor("191213486", "Georgi", "Zapryanov", "02 965-2680", "gszap@tu-sofia.bg", "1311", "Computer Systems"));
    tutors.add(new Tutor("191213488", "Petar", "Marinov", "02 965-2224", "pmarinov@tu-sofia.bg", "1205", "Computer Systems"));
    tutors.add(new Tutor("191213856", "Neven", "Nikolov", "", "n.nikolov@tu-sofia.bg", "1406", "Computer Systems"));
    tutors.add(new Tutor("191213886", "Rumen", "Trifonov", "", "r_trifonov@tu-sofia.bg", "1326", "Computer Systems"));
    tutors.add(new Tutor("191213156", "Galya", "Pavlova", "02 965-3523", "raicheva@tu-sofia.bg", "1200", "Computer Systems"));
    tutors.add(new Tutor("191213416", "Diana", "Grigorova", "02 965-3523", "dgrigorova@tu-sofia.bg", "1200", "Computer Systems"));
    tutors.add(new Tutor("191213334", "Yavor", "Tomov", "02 965-2224", "yavor_tomov@tu-sofia.bg", "1205", "Cyber Security"));
  }

/*  HikariCP - why?
  With connection pooling, when you call connection.close(), the connection is not actually closed;
  it"s returned to the connection pool for reuse by other parts of your application.
  This approach is more efficient and performs better
  than opening and closing a new connection for every database operation.*/
}