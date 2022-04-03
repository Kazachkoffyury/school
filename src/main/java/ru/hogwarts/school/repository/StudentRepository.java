package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(Integer age);
    List<Student> findByAgeBetween(Integer min ,Integer max);
    @Query(value = "SELECT COUNT(*) FROM Student ",nativeQuery = true)
    Integer getCountStudent();
    @Query(value = "SELECT AVG (age) FROM student",nativeQuery = true)
    Integer getAvgAgeStudent();
    @Query(value = "SELECT  *  FROM student ORDER BY id DESC LIMIT 5",nativeQuery = true)
    List<Student> getLastStudent();

}
