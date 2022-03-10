package ru.hogwarts.school.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);


    }

    @GetMapping("{id}")
    public Faculty findFaculty(@PathVariable int id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping("{id}")
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updateFaculty);

    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFaculty(@PathVariable int id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public Collection<Faculty> getAllFaculties() {
        return facultyService.getAll();
    }

    @GetMapping("/color{color}")
    public Collection<Faculty> getAllFacultiesWithColor(@PathVariable String color) {
        return facultyService.findByColor(color);
    }

    @GetMapping(params = {"colorFaculty","name"})
    public Collection<Faculty> getAllFacultiesWithColorOrName(@RequestParam (required = false)String colorFaculty,@RequestParam(required = false) String name) {
        return facultyService.findByColorOrName(colorFaculty,name);
    }

}
