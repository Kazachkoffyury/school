package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private Map<Integer, Student> students = new HashMap<>();
    private int lastId=0;



    @Override
    public  Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId,student);
        return student;
    }

    @Override
    public Student findStudent(int id) {
        return students.get(id);
    }

    @Override
    public Student updateStudent(Student student) {
        students.put(student.getId(),student);
        return student;
    }

    @Override
    public Student deleteStudent(int id) {
        return students.remove(id);


    }

    @Override
    public Collection<Student> getAll() {
        return students.values();
    }

    @Override
    public Collection<Student> getStudentWithAge(int age) {
        return students.values().stream().filter(student -> student.getAge()== age).collect(Collectors.toList());
    }
}
