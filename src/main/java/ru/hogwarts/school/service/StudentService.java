package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    public  Student createStudent(Student student);
    public Student findStudent(long id);
    public Student updateStudent(Student student);
    public void deleteStudent(long id);
    public Collection<Student> getAll();
    public Collection<Student> findByAge(int age);
    public Collection<Student> findByAgeBetween(int minAge, int maxAge);
}


