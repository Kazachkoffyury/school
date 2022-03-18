package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;


import java.util.Collection;

@RestController
@RequestMapping("student")


public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable long id){
        return studentService.findStudent(id);
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student createStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createStudent);
    }

    @PostMapping("{id}")
    public ResponseEntity updateStudent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable long id) {
         studentService.deleteStudent(id);
         return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Student> getAllStudent() {
        return studentService.getAll();
    }

    @GetMapping("/age{age}")
    public Collection<Student> getStudentWithAge(@PathVariable int age) {
        return studentService.findByAge(age);
    }

    @GetMapping("/count")
    public Integer getCountStudent() {
        return studentService.getCountStudent();
    }

    @GetMapping("/get-avg-age")
    public Integer getAvgAgeStudent() {
        return studentService.getAvgAgeStudent();
    }

    @GetMapping("get-last-student")
    public  Collection<Student> getLastStudent() {
        return studentService.getLastStudent();
    }



    @GetMapping(params = {"minAge","maxAge"})
    public  Collection<Student> getStudentByAgeBetween(@RequestParam(required = false) int minAge, @RequestParam(required = false) int maxAge) {
        return studentService.findByAgeBetween(minAge,maxAge);
    }



}
