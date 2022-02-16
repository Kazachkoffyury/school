package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    public  Student createStudent(Student student);
    public Student findStudent(int id);
    public Student updateStudent(Student student);
    public Student deleteStudent(int id);
    public Collection<Student> getAll();
    public Collection<Student> getStudentWithAge(int age);
}
