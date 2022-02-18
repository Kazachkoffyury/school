package ru.hogwarts.school.service.impl;

import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Service

public class FacultyServiceImpl implements FacultyService {
    private Map<Integer,Faculty> faculties = new HashMap<>();
    private int lastId =0;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId,faculty);
        return faculty;
    }

    @Override
    public Faculty findFaculty(int id) {
        return faculties.get(id);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        faculties.put(faculty.getId(),faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(int id) {
        return faculties.remove(id);
    }

    @Override
    public Collection<Faculty> getAll() {
        return faculties.values();
    }

    @Override
    public Collection<Faculty> getFacultiesWithColor(String color) {
        return faculties.values().stream().filter(faculty -> faculty.getColor().equals(color)).collect(Collectors.toList());
    }
}
