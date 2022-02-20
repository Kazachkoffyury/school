package ru.hogwarts.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public  Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(int id) {

        return studentRepository.getById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
         studentRepository.deleteById(id);


    }

    @Override
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }


    @Override
    public List<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }
}