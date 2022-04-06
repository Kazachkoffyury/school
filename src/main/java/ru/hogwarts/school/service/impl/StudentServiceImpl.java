package ru.hogwarts.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public  Student createStudent(Student student) {
        log.info("Student was create");
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long id) {
        log.info("Student is find");
        return studentRepository.getById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        log.info("Student is update");
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        log.info("Student delete");
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

    @Override
    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge,maxAge);
    }

    @Override
    public Integer getCountStudent() {
        return studentRepository.getCountStudent();
    }

    @Override
    public Integer getAvgAgeStudent() {

        return (int)studentRepository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    @Override
    public Collection<Student> getLastStudent() {
        return studentRepository.getLastStudent();
    }

    @Override
    public List<String> getStudentWithPrefixA() {
        return studentRepository.findAll().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(it -> it.startsWith("А"))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public void getStudentInThreadsParalels() {
       Thread thread1 = new Thread(()-> {
          printName(1);
          printName(2);
        });

       Thread thread2 = new Thread(()-> {
           printName(3);
           printName(4);
       });

       thread1.start();
       thread2.start();
       printName(5);
       printName(6);

    }

    @Override
    public void geyStudentInThreadsSynchronized() {
        Thread thread1 = new Thread(()-> {
           printNameSync(1);
           printNameSync(2);
        });

        Thread thread2 = new Thread(() -> {
            printNameSync(3);
            printNameSync(4);
        });


        printNameSync(5);
        printNameSync(6);
        thread1.start();
        thread2.start();

    }


    public void printName(long id) {
        System.out.println(studentRepository.getById(id).getName());
    }

    public synchronized void printNameSync(long id) {
        System.out.println(studentRepository.getById(id).getName());
    }
}
